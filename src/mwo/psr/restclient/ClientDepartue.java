// Kod klasy utworzony na podstawie tutoriala: http://www.tutorialspoint.com/restful/restful_first_application.htm

package mwo.psr.restclient;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import mwo.ttss.Departures;
import mwo.ttss.Stop;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientDepartue {

    private Client client;

    public static void main(String[] args) {
        ClientDepartue c = new ClientDepartue();
        c.init();
        c.interactiveUI(c);
    }

    public void interactiveUI(ClientDepartue client) {
        List<Stop> list;

        System.out.println("-----------------------------------------------------");
        System.out.println("|Welcome to TTSS Krakow                             |");
        System.out.println("-----------------------------------------------------");


        do {
            String name = client.readStop();
            list = client.getStops(name);
            if (list.size() > 2) {
                System.out.println("I found " + (list.size() - 1) + " stops.");
                System.out.println("Please write correct full name of stop:");
                listStops(list);
            } else if (list.size() == 2){

               // System.out.println("Below connection for: " + name);
                getTimetable(list.get(1).getId());
            } else {
                System.out.println(name + " stop was not found. Please try again.");

            }


        } while (true);


    }

    public String readStop() {

        String name = null;
        java.io.BufferedReader readName = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        try {
            System.out.print("Write Stop: ");
            name = readName.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }

    public List<Stop> getStops(String stopName) {
        //tablica konwersji znaków  UTF-8   https://www.ia.pw.edu.pl/~jurek/js/kody/
        stopName = stopName.replace(" ", "+")
                .replace("ó", "%C3%B3")
                .replace("ą", "%C4%85")
                .replace("ć", "%C4%87")
                .replace("ę", "%C4%99")
                .replace("ł", "%C5%82")
                .replace("ń", "%C5%84")
                .replace("ś", "%C5%9B")
                .replace("ź", "%C5%BA")
                .replace("ż", "%C5%BC")
                .replace("Ł", "%C5%81")
                .replace("Ś", "%C5%9A")
                .replace("Ż", "%C5%BB")
        ;

        String target1 = "http://www.ttss.krakow.pl/internetservice/services/lookup/autocomplete/json?query=" + stopName + "&mode=departue&language=pl";
try {
    List<Stop> stop = client
            .target(target1)
            .request(MediaType.APPLICATION_JSON)
            .get(Response.class)
            .readEntity(new GenericType<List<Stop>>() {
            });

        return stop;

    }
    catch (Exception ex){
         System.out.println("Blad wprowadzania: " );
        //ex.printStackTrace();
    }
        //return stop;
        return new ArrayList<Stop>();
    }

    public void listStops(List<Stop> stops) {
        System.out.printf("-----------------------------------------------------------------------\n");
        System.out.printf("|  %-10s  |  %-50s  |\n", "Id", "Stop Name");
        System.out.printf("-----------------------------------------------------------------------\n");
        for (Stop stop : stops) {
            if (stop.getId() != null) {
                System.out.printf("|  %-10s  |  %-50s  |\n", stop.getId(), stop.getName()
                        .replace("&oacute;","ó")
                .replace("&#261;","ą"));
            }
        }
        System.out.printf("-----------------------------------------------------------------------\n");
    }

    public void getTimetable(String id) {


        Departures dep = client
                .target("http://www.ttss.krakow.pl/internetservice/services/passageInfo/stopPassages/stop?stop=" + id.trim() + "&mode=departure&language=pl")
                .request(MediaType.APPLICATION_JSON)
                .get(Departures.class);

        System.out.println("Below connection for: " + dep.getStopName().toString());
        System.out.println("The nearest departures: " + dep.getActual() + "\n");
    }


    private void init() {
        client = ClientBuilder.newClient();
        client.register(JacksonJsonProvider.class);
    }



}
