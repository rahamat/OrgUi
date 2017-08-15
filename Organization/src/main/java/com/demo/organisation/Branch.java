
package com.demo.organisation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "branchId",
    "employees",
})
public class Branch implements Serializable
{
	private final static long serialVersionUID = -7563960483192972855L;

    @JsonProperty("branchId")
    private String branchId;

    @JsonProperty("employees")
    private List<Employee> employees = new ArrayList<Employee>();

    @JsonProperty("branchId")
	public String getBranchId() {
		return branchId;
	}

    @JsonProperty("branchId")
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

    @JsonProperty("employees")
	public List<Employee> getEmployees() {
		return employees;
	}

    @JsonProperty("employees")
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
 
    

    

}
