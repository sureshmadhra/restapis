package com.ibm.rest.apis.employeproject.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path ("school")
public class School {

	
		@GET
		@Produces (MediaType.APPLICATION_XML)
		public String getAllSchoolDetails() {
			return "DPS Greater Noida, DPS Delhi, DPS Noida, DPS Gurgaon";
		}
	
		
		@GET
		@Path("schooladdress")
		@Produces (MediaType.APPLICATION_JSON)
		public String getSchoolAddress() {
			
			return "DPS Greater Noida, UP-3093";
		}
	
	
}
