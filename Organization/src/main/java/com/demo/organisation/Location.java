
package com.demo.organisation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "locId",
    "zones",
})
public class Location implements Serializable
{

	private final static long serialVersionUID = -1983318136767535101L;
	
    @JsonProperty("locId")
    private String locId;
    @JsonProperty("zones")
    private List<Zone> zones = new ArrayList<Zone>();
    
    @JsonProperty("locId")
	public String getLocId() {
		return locId;
	}
    
    @JsonProperty("locId")
	public void setLocId(String locId) {
		this.locId = locId;
	}
    
    @JsonProperty("zones")
	public List<Zone> getZones() {
		return zones;
	}
    
    @JsonProperty("zones")
	public void setZones(List<Zone> zones) {
		this.zones = zones;
	}
    
    

}
