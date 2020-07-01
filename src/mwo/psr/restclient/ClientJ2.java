// Kod klasy utworzony na podstawie tutoriala: http://www.tutorialspoint.com/restful/restful_first_application.htm

package mwo.psr.restclient;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import mwo.ttss.Actual;
import mwo.ttss.Departures;
import mwo.ttss.Stop;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.client.Entity;

public class ClientJ2 {

	private Client client;
	private static final String SUCCESS_RESULT = "<result>success</result>";
	private static final String PASS = "pass";
	private static final String FAIL = "fail";

	public static void main(String[] args) {
		ClientJ2 c = new ClientJ2();
		c.init();
		c.interactiveUI(c);
	}

	public void interactiveUI(ClientJ2 client) {
//		String line = null;
//		java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		
		do {
			client.getDepartures();
		} while (true);
		
//		do {
//			try {
//				System.out.print("==> ");
//				System.out.flush();
//				line = in.readLine();
//				if (line == null) {
//					break;
//				}
//				if (line.equals("g1x")) {
//					client.getUser1X();
//				} else if (line.equals("g2x")) {
//					client.getUser1X();
//				} else if (line.equals("gj")) {
//					client.getUserJ();
//				} else if (line.equals("ax")) {
//					client.addUserX();
//				} else if (line.equals("aj")) {
//					client.addUserJ();
//				} else if (line.equals("ggj")) {
//					client.getAllUsersJ();
//				} else if (line.equals("ggx")) {
//					client.getAllUsersX();
//				} else if (line.equals("raw")) {
//					client.getRawJson();
//				} 
//				else if (line.equals("x")) {
//				} else {
//					System.out.println("unknown command `" + line + "'");
//				}
//			} catch (Exception ex) {
//				// System.out.println(ex);
//				ex.printStackTrace();
//			}
//		} while (!line.equals("x"));
	
	}

	public void getDepartures() { //ttss aby wywolaæ
		
		String stopName = null;
		java.io.BufferedReader inStopName = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		try {
			System.out.println("Podaj przystanek: ");
			stopName = inStopName.readLine();
			stopName = stopName.replace(" ", "+");
		} catch (IOException e) {
			e.printStackTrace();
		}

		String target1 = "http://www.ttss.krakow.pl/internetservice/services/lookup/autocomplete/json?query=" + stopName + "&language=pl";
		
		List<Stop> stop = client
                .target(target1)
                .request(MediaType.APPLICATION_JSON)
                .get(Response.class)
                .readEntity(new GenericType<List<Stop>>() {});
		
		String stopID = stop.get(1).getId();
		
		Departures dep = client
				.target("http://www.ttss.krakow.pl/internetservice/services/passageInfo/stopPassages/stop?stop=" + stopID + "&mode=departure&language=pl")
				.request(MediaType.APPLICATION_JSON)
				.get(Departures.class);

		System.out.println("Najbli¿sze odjazdy: " + dep.getActual().toString() + "\n");
		
	}
	
	private void init() {
		client = ClientBuilder.newClient();
		// client.register(new Authenticator("pum", "pum123"));
		client.register(JacksonJsonProvider.class);
	}

	public void getRawJson() {
		System.out.println(
				"\n\n*** Starting test case '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'...");

		String res = client
				.target("http://localhost:8080/SampleRestService/rest/UserManagementService/usersj/2")
				.request(MediaType.APPLICATION_JSON)
				.get().readEntity(String.class);

		String result = PASS;
		if (res == null)
			result = FAIL;

		System.out.println("Result: " + res);
		System.out.println(
				"\n\n*** Test case '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "' finished");
	}

	public void getAllUsers() {
		System.out.println(
				"\n\n*** Starting test case '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'...");

		GenericType<List<User>> list = new GenericType<List<User>>() {
		};
		List<User> users = client.target("http://localhost:8080/SampleRestService/rest/UserManagementService/usersx")
				.request(MediaType.APPLICATION_XML).get(list);
		String result = PASS;
		if (users.isEmpty()) {
			result = FAIL;
		}
		System.out.println("Result: " + result);
		System.out.println(
				"\n\n*** Test case '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "' finished");
	}

	private void updateUserX() {
		System.out.println(
				"\n\n*** Starting test case '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'...");

		Form form = new Form();
		form.param("id", "15");
		form.param("name", "wacek");
		// form.param("profession", "entomolog");

		String callResult = client.target("http://localhost:8080/SampleRestService/rest/UserManagementService/usersx")
				.request(MediaType.APPLICATION_XML)
				.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), String.class);
		String result = PASS;
		if (!SUCCESS_RESULT.equals(callResult)) {
			result = FAIL;
		}

		System.out.println("Result: " + result);
		System.out.println(
				"\n\n*** Test case '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "' finished");
	}

	private void addUserX() {
		System.out.println(
				"\n\n*** Starting test case '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'...");

		Form form = new Form();
		form.param("id", "14");
		form.param("name", "Tomasz S³oñ");
		form.param("profession", "szewc");

		String callResult = client.target("http://localhost:8080/SampleRestService/rest/UserManagementService/usersx")
				.request(MediaType.APPLICATION_XML)
				.put(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), String.class);

		String result = PASS;
		if (!SUCCESS_RESULT.equals(callResult)) {
			result = FAIL;
		}

		System.out.println("Result: " + callResult);
		System.out.println(
				"\n\n*** Test case '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "' finished");
	}

	public void addUserJ() {
		System.out.println(
				"\n\n*** Starting test case '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'...");

		User u = new User(24, "Jozek", "Stroz");
		String callResult = client.target("http://localhost:8080/SampleRestService/rest/UserManagementService/usersj")
				.request(MediaType.APPLICATION_XML).put(Entity.entity(u, MediaType.APPLICATION_JSON), String.class);

		String result = PASS;
		if (!SUCCESS_RESULT.equals(callResult))
			result = FAIL;

		System.out.println("Result: " + callResult);
		System.out.println(
				"\n\n*** Test case '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "' finished");
	}

	public void getUser1X() {
		System.out.println(
				"\n\n*** Starting test case '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'...");

		GenericType<User> userT = new GenericType<User>() {
		};
		User user = client.target("http://localhost:8080/SampleRestService/rest/UserManagementService/usersx/2")
				.request(MediaType.APPLICATION_XML).get(userT);

		String result = PASS;
		if (user == null)
			result = FAIL;

		System.out.println("Result: " + result);
		System.out.println(
				"\n\n*** Test case '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "' finished");
	}

	public void getUser2X() {
		System.out.println(
				"\n\n*** Starting test case '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'...");

		User sampleUser = new User();
		sampleUser.setId(1);

		User user = client.target("http://localhost:8080/SampleRestService/rest/UserManagementService/usersx")
				.path("/{userid}").resolveTemplate("userid", 2).request(MediaType.APPLICATION_XML).get(User.class);

		String result = FAIL;
		if (sampleUser != null && sampleUser.getId() == user.getId())
			result = PASS;

		System.out.println("Result: " + result);
		System.out.println(
				"\n\n*** Test case '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "' finished");
	}

	public void getUserJ() {
		System.out.println("\n\n*** Starting test case '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'...");

		User user = client.target("http://localhost:8080/SampleRestService/rest/UserManagementService/usersj/2").request(MediaType.APPLICATION_JSON).get(User.class);

		String result = PASS;
		if (user == null)
			result = FAIL;

		System.out.println("Result: " + result);
		System.out.println("\n\n*** Test case '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "' finished");
	}
	
	public void getAllUsersX() {
		System.out.println(
				"\n\n*** Starting test case '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'...");

		GenericType<List<User>> ulT = new GenericType<List<User>>() {
		};
		List<User> users = client.target("http://localhost:8080/SampleRestService/rest/UserManagementService/usersx")
				.request(MediaType.APPLICATION_XML).get(ulT);

		String result = PASS;
		if (users == null)
			result = FAIL;

		System.out.println("Result: " + result + ", Size: " + users.size());
		System.out.println(
				"\n\n*** Test case '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "' finished");
	}

	public void getAllUsersJ() {
		System.out.println(
				"\n\n*** Starting test case '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'...");

		GenericType<List<User>> ulT = new GenericType<List<User>>() {
		};
		List<User> users = client.target("http://localhost:8080/SampleRestService/rest/UserManagementService/usersj2") // UWAGA
				.request(MediaType.APPLICATION_JSON).get(ulT);

		String result = PASS;
		if (users == null)
			result = FAIL;

		System.out.println("Result: " + result + ", Size: " + users.size());
		System.out.println(
				"\n\n*** Test case '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "' finished");
	}

}
