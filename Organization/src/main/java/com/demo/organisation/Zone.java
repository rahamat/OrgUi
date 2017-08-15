
package com.demo.organisation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "zoneName",
    "branches"
})
public class Zone implements Serializable
{

    @JsonProperty("zoneName")
    private String zoneName;
    @JsonProperty("branches")
    private List<Branch> branches = new ArrayList<Branch>();

    private final static long serialVersionUID = -258229831178803774L;

    @JsonProperty("zoneName")
    public String getZoneName() {
        return zoneName;
    }

    @JsonProperty("zoneName")
    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    @JsonProperty("branches")
	public List<Branch> getBranches() {
		return branches;
	}
    @JsonProperty("branches")
	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}

   

    

}
