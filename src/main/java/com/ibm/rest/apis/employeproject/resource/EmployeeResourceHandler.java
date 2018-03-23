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
import javax.ws.rs.core.MediaType;

import com.ibm.rest.apis.employeproject.model.Employee;
import com.ibm.rest.apis.employeproject.service.EmployeeService;

@Path("employee")


public class EmployeeResourceHandler {
	
	EmployeeService employeeService = new EmployeeService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getMessages() {
		System.out.println("Get Called");
		return employeeService.getAllEmployees();
	}
	
	@GET
	@Path("/{employeeID}")
	@Produces(MediaType.APPLICATION_XML)
	public Employee getEmployeeByID(@PathParam("employeeID") long id) {
		
		return employeeService.getEmployeebyId(id);
	}
	
		
	@POST
	@Produces (MediaType.APPLICATION_JSON)
	@Consumes (MediaType.APPLICATION_JSON)
	
	public Employee addEmp(Employee emp) {
		return employeeService.addEmployee(emp);
	}
	
	
	@PUT
	@Path ("/{id}")
	@Produces (MediaType.APPLICATION_JSON)
	@Consumes (MediaType.APPLICATION_JSON)

	
	public Employee updateEmployee(@PathParam ("id") long id, Employee emp) {
		emp.setId(id);
			return employeeService.updateEmployeeDetails(emp);
	}
	
	
	@DELETE
	
	@Path ("/{id}")
	public Employee deleteEmp(@PathParam ("id") long id) {
		
		System.out.println("Delete Called" + id);
	
		return employeeService.removeEmployeeDetails(id);
	}
	
}

