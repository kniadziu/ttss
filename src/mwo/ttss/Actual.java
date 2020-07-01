
package mwo.ttss;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "actualRelativeTime", "actualTime", "direction", "mixedTime", "passageid", "patternText", "plannedTime", "routeId", "status", "tripId", "vehicleId" })

public class Actual {

	@JsonProperty("actualRelativeTime")
	private long actualRelativeTime;
	@JsonProperty("actualTime")
	private String actualTime;
	@JsonProperty("direction")
	private String direction;
	@JsonProperty("mixedTime")
	private String mixedTime;
	@JsonProperty("passageid")
	private String passageid;
	@JsonProperty("patternText")
	private String patternText;
	@JsonProperty("plannedTime")
	private String plannedTime;
	@JsonProperty("routeId")
	private String routeId;
	@JsonProperty("status")
	private String status;
	@JsonProperty("tripId")
	private String tripId;
	@JsonProperty("vehicleId")
	private String vehicleId;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("actualRelativeTime")
	public long getActualRelativeTime() {
		return actualRelativeTime;
	}

	@JsonProperty("actualRelativeTime")
	public void setActualRelativeTime(long actualRelativeTime) {
		this.actualRelativeTime = actualRelativeTime;
	}

	@JsonProperty("actualTime")
	public String getActualTime() {
		return actualTime;
	}

	@JsonProperty("actualTime")
	public void setActualTime(String actualTime) {
		this.actualTime = actualTime;
	}

	@JsonProperty("direction")
	public String getDirection() {
		return direction;
	}

	@JsonProperty("direction")
	public void setDirection(String direction) {
		this.direction = direction;
	}

	@JsonProperty("mixedTime")
	public String getMixedTime() {
		return mixedTime;
	}

	@JsonProperty("mixedTime")
	public void setMixedTime(String mixedTime) {
		this.mixedTime = mixedTime;
	}

	@JsonProperty("passageid")
	public String getPassageid() {
		return passageid;
	}

	@JsonProperty("passageid")
	public void setPassageid(String passageid) {
		this.passageid = passageid;
	}

	@JsonProperty("patternText")
	public String getPatternText() {
		return patternText;
	}

	@JsonProperty("patternText")
	public void setPatternText(String patternText) {
		this.patternText = patternText;
	}

	@JsonProperty("plannedTime")
	public String getPlannedTime() {
		return plannedTime;
	}

	@JsonProperty("plannedTime")
	public void setPlannedTime(String plannedTime) {
		this.plannedTime = plannedTime;
	}

	@JsonProperty("routeId")
	public String getRouteId() {
		return routeId;
	}

	@JsonProperty("routeId")
	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("tripId")
	public String getTripId() {
		return tripId;
	}

	@JsonProperty("tripId")
	public void setTripId(String tripId) {
		this.tripId = tripId;
	}

	@JsonProperty("vehicleId")
	public String getVehicleId() {
		return vehicleId;
	}

	@JsonProperty("vehicleId")
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@Override
	public String toString() {
		return (this.getDirection() + " - " + this.getActualTime());
	}

}
