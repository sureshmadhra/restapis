package com.ibm.rest.apis.employeproject.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ibm.rest.apis.employeproject.model.Department;

//@Path ("/")

public class DeptResourceHandle {

	@GET
	@Produces (MediaType.TEXT_PLAIN)
	public String getMessage() {
		return "hello world";
	}
	
	
	@POST 
	@Produces (MediaType.TEXT_PLAIN) 
	@Consumes (MediaType.TEXT_PLAIN) 
	//@Consumes (MediaType.APPLICATION_JSON)	
		public String  addDepartment (@PathParam("departmid") long dept, Department Department)
		{	
			return dept+"";
			
		}
		
	
	
}
