
package com.demo.organisation;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "empId"
})
public class Employee implements Serializable
{

	private static final long serialVersionUID = -3380839201591574369L;
	
	@JsonProperty("empId")
    private String empId;

	@JsonProperty("empId")
	public String getEmpId() {
		return empId;
	}

	@JsonProperty("empId")
	public void setEmpId(String empId) {
		this.empId = empId;
	}
    
    

}
