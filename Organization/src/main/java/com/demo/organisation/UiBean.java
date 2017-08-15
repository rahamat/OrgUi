package com.demo.organisation;

import java.io.Serializable;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.json.JSONObject;


@ManagedBean
@ViewScoped
public class UiBean implements Serializable{

	private static final long serialVersionUID = 153327567390620909L;
	
	private Organisation organisation;
	private Location location;
	private Zone zone;
	private Branch branch;
	private Boolean renderPanel = Boolean.FALSE;
	
	public Organisation getOrganisation() {
		return organisation;
	}

	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Boolean getRenderPanel() {
		return renderPanel;
	}

	public void setRenderPanel(Boolean renderPanel) {
		this.renderPanel = renderPanel;
	}

	public void loadUi() {
		organisation = JsonBuilder.jsonBuilder();
		JSONObject jsonObject = new JSONObject(organisation);
		renderPanel = Boolean.TRUE;
		RequestContext.getCurrentInstance().addCallbackParam("uiOrgData",jsonObject);
	}
	
	public void clickedResource(){
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String resourceType = params.get("resourceType");
        String resourceId = params.get("resourceId");
        
        System.out.println("Resource Type : "+ resourceType);
        System.out.println("Resource Id : "+resourceId);
        
        constructUi(resourceType, resourceId);
        
	}

	private void constructUi(String resourceType, String resourceId) {
		if("location".equalsIgnoreCase(resourceType)) {
			/*location = organisation.getLocations().stream()                       
	                .filter(location -> resourceId.equalsIgnoreCase(location.getLocId()))        
	                .findAny()                                   
	                .orElse(new Location()); 		
			*/
			for(Location orgLocation : organisation.getLocations()) {
				if(resourceId.equalsIgnoreCase(orgLocation.getLocId())) {
					setLocation(orgLocation);
					RequestContext.getCurrentInstance().update("uiForm:locPanel");
					return;
				}					
			}	
			
		}
		else if("zone".equalsIgnoreCase(resourceType)) {
			/*List<Zone> zoneLists = organisation.getLocations().stream().map(Location::getZones).collect(Collectors.toList())
					.stream().flatMap(List::stream).collect(Collectors.toList());
			zone = zoneLists.stream().filter(zone-> resourceId.equalsIgnoreCase(zone.getZoneName())).findAny().orElse(new Zone());
			*/
			for(Location orgLocation : organisation.getLocations()) {
				for(Zone locZone:orgLocation.getZones()) {
					if(resourceId.equalsIgnoreCase(locZone.getZoneName())) {
						setZone(locZone);
						RequestContext.getCurrentInstance().update("uiForm:zonePanel");
						return;
					}
				}
			}
			
			
		}
		
		else if("branch".equalsIgnoreCase(resourceType)) {
			for(Location orgLocation : organisation.getLocations()) {
				for(Zone locZone:orgLocation.getZones()) {
					for(Branch zoneBranch : locZone.getBranches()) {
						if(resourceId.equalsIgnoreCase(zoneBranch.getBranchId())) {
							setBranch(zoneBranch);
							RequestContext.getCurrentInstance().update("uiForm:branchPanel");
							return;
						}
					}
				}
			}
		}
	}
	
	
}
