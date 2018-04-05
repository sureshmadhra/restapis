package com.ibm.rest.apis.employeproject.authentication;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//@Path ("secure")

public class SecureEmployeeResource {

		@GET
		@Path ("login")
		@Produces (MediaType.TEXT_PLAIN)
		public String login() {
			System.out.println("inside secure");
			return "Success";
		}
}
