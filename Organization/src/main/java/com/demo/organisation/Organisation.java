
package com.demo.organisation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "orgName",
    "locations"
})
public class Organisation implements Serializable
{

	private final static long serialVersionUID = -7186048118638169678L;
	 
    @JsonProperty("orgName")
    private String orgName;
    @JsonProperty("locations")
    private List<Location> locations = new ArrayList<Location>();
   

    @JsonProperty("orgName")
    public String getOrgName() {
        return orgName;
    }

    @JsonProperty("orgName")
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
    
    @JsonProperty("locations")
	public List<Location> getLocations() {
		return locations;
	}

    @JsonProperty("locations")
	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
    
    

}
