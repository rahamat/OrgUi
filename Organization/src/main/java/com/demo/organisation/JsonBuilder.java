package com.demo.organisation;

import java.util.concurrent.ThreadLocalRandom;

public class JsonBuilder {
	
	public static Organisation jsonBuilder() {
		Organisation organisation = null;
		organisation = staticData();
		//organisation = buildJSONForEntireOrg();
		return organisation;
	}
	
	private static Organisation staticData() {
		Organisation organisation = new Organisation();
		organisation.setOrgName("My Org");
		
		for(int loc = 0; loc < 2 ; loc++){
			Location location = new Location();
			location.setLocId(ResourceNamer.randomResourceName("loc", 15));
			for(int zon = 0;zon < 3; zon++){
				Zone zone = new Zone();
				zone.setZoneName(ResourceNamer.randomResourceName("zone", 15));
				for(int bran = 0; bran < 2 ; bran++){
					Branch branch = new Branch();
					branch.setBranchId(ResourceNamer.randomResourceName("branch", 15));
					for(int em = 0;em <2; em++){
						Employee employee = new Employee();
						employee.setEmpId(ResourceNamer.randomResourceName("employee", 14));
						branch.getEmployees().add(employee);
					}
					zone.getBranches().add(branch);
				}
				location.getZones().add(zone);
			}
			organisation.getLocations().add(location);
		}
		
		return organisation;
	}

	private static Organisation buildJSONForEntireOrg() {
		Organisation organisation = new Organisation();
		organisation.setOrgName("My Org");
		
		for(int loc = 0; loc < randomCount(3); loc++){
			Location location = new Location();
			location.setLocId(ResourceNamer.randomResourceName("loc", 24));
			for(int zon = 0;zon < randomCount(5); zon++){
				Zone zone = new Zone();
				zone.setZoneName(ResourceNamer.randomResourceName("zone", 15));
				for(int br = 0; br < randomCount(5); br++){
					Branch branch = new Branch();
					branch.setBranchId(ResourceNamer.randomResourceName("branch", 24));
					for(int em = 0;em <randomCount(10); em++){
						Employee employee = new Employee();
						employee.setEmpId(ResourceNamer.randomResourceName("employee", 24));
						branch.getEmployees().add(employee);
					}
					zone.getBranches().add(branch);
				}
				location.getZones().add(zone);
			}
			organisation.getLocations().add(location);
		}
		
		return organisation;
	}
	
	private static int randomCount(int max){
		return ThreadLocalRandom.current().nextInt(1, max + 1); 
	}

}
