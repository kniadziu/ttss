
package mwo.ttss;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "alerts",
    "authority",
    "directions",
    "id",
    "name",
    "routeType",
    "shortName"
})
public class Route {

    @JsonProperty("alerts")
    private List<Object> alerts = null;
    @JsonProperty("authority")
    private String authority;
    @JsonProperty("directions")
    private List<String> directions = null;
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("routeType")
    private String routeType;
    @JsonProperty("shortName")
    private String shortName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("alerts")
    public List<Object> getAlerts() {
        return alerts;
    }

    @JsonProperty("alerts")
    public void setAlerts(List<Object> alerts) {
        this.alerts = alerts;
    }

    @JsonProperty("authority")
    public String getAuthority() {
        return authority;
    }

    @JsonProperty("authority")
    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @JsonProperty("directions")
    public List<String> getDirections() {
        return directions;
    }

    @JsonProperty("directions")
    public void setDirections(List<String> directions) {
        this.directions = directions;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("routeType")
    public String getRouteType() {
        return routeType;
    }

    @JsonProperty("routeType")
    public void setRouteType(String routeType) {
        this.routeType = routeType;
    }

    @JsonProperty("shortName")
    public String getShortName() {
        return shortName;
    }

    @JsonProperty("shortName")
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
