
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
@JsonPropertyOrder({ "actual", "directions", "firstPassageTime", "generalAlerts", "lastPassageTime", "old", "routes", "stopName", "stopShortName" })
public class Departures {

	@JsonProperty("actual")
	private List<Actual> actual = null;
	@JsonProperty("directions")
	private List<Object> directions = null;
	@JsonProperty("firstPassageTime")
	private long firstPassageTime;
	@JsonProperty("generalAlerts")
	private List<Object> generalAlerts = null;
	@JsonProperty("lastPassageTime")
	private long lastPassageTime;
	@JsonProperty("old")
	private List<Old> old = null;
	@JsonProperty("routes")
	private List<Route> routes = null;
	@JsonProperty("stopName")
	private String stopName;
	@JsonProperty("stopShortName")
	private String stopShortName;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("actual")
	public List<Actual> getActual() {
		return actual;
	}

	@JsonProperty("actual")
	public void setActual(List<Actual> actual) {
		this.actual = actual;
	}

	@JsonProperty("directions")
	public List<Object> getDirections() {
		return directions;
	}

	@JsonProperty("directions")
	public void setDirections(List<Object> directions) {
		this.directions = directions;
	}

	@JsonProperty("firstPassageTime")
	public long getFirstPassageTime() {
		return firstPassageTime;
	}

	@JsonProperty("firstPassageTime")
	public void setFirstPassageTime(long firstPassageTime) {
		this.firstPassageTime = firstPassageTime;
	}

	@JsonProperty("generalAlerts")
	public List<Object> getGeneralAlerts() {
		return generalAlerts;
	}

	@JsonProperty("generalAlerts")
	public void setGeneralAlerts(List<Object> generalAlerts) {
		this.generalAlerts = generalAlerts;
	}

	@JsonProperty("lastPassageTime")
	public long getLastPassageTime() {
		return lastPassageTime;
	}

	@JsonProperty("lastPassageTime")
	public void setLastPassageTime(long lastPassageTime) {
		this.lastPassageTime = lastPassageTime;
	}

	@JsonProperty("old")
	public List<Old> getOld() {
		return old;
	}

	@JsonProperty("old")
	public void setOld(List<Old> old) {
		this.old = old;
	}

	@JsonProperty("routes")
	public List<Route> getRoutes() {
		return routes;
	}

	@JsonProperty("routes")
	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}

	@JsonProperty("stopName")
	public String getStopName() {
		return stopName;
	}

	@JsonProperty("stopName")
	public void setStopName(String stopName) {
		this.stopName = stopName;
	}

	@JsonProperty("stopShortName")
	public String getStopShortName() {
		return stopShortName;
	}

	@JsonProperty("stopShortName")
	public void setStopShortName(String stopShortName) {
		this.stopShortName = stopShortName;
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
