package com.ibm.rest.apis.employeproject.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.ibm.rest.apis.employeproject.model.Department;
import com.ibm.rest.apis.employeproject.service.DepartmentService;

@Path("/")

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)


public class DepartmentResourceHandler {
	private DepartmentService departmentService = new DepartmentService();

	public DepartmentResourceHandler(){
		
	}

		@GET
		public List<Department> getAllDepartments(@PathParam("employeeKeyId") long employeeKeyId) {
		
		return departmentService.getAllDepartments(employeeKeyId);
		}
	
	
		@POST
		
		public Department addDepartment(@PathParam("employeeKeyId") long employeeKeyId, Department department,@Context UriInfo uriInfo) {
			System.out.println("Inside add department");
		return departmentService.addDepartment(employeeKeyId, department,uriInfo);
		}
	
		
	
		
		@PUT
		@Path("/{departmentID}")
	
		public Department updateDepartment(@PathParam("employeeKeyId") long employeeKeyId, @PathParam("departmentID") long departmentID, Department department) {
		department.setDepartmentID(departmentID);
		return departmentService.updateDepartmentDetails(employeeKeyId, department);
		}
	
		@DELETE
		@Path("/{departmentID}")
		public void deleteDepartment(@PathParam("employeeKeyId") long employeeKeyId, @PathParam("departmentID") long departmentID) {
		departmentService.removeDepartment(employeeKeyId, departmentID);
		}
	
		@GET
		@Path("/{departmentID}")
		public Department getMessage(@PathParam("employeeKeyId") long employeeKeyId, @PathParam("departmentID") long departmentID) {
		return departmentService.getDepartment(employeeKeyId, departmentID);
		}
}
