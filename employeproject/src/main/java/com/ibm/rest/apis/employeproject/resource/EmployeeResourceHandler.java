package com.ibm.rest.apis.employeproject.resource;
import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import com.ibm.rest.apis.employeproject.errorhandler.ErrorMessage;
import com.ibm.rest.apis.employeproject.exception.EmployeeException;
import com.ibm.rest.apis.employeproject.exception.InvalidEmpIdException;
import com.ibm.rest.apis.employeproject.model.Employee;
import com.ibm.rest.apis.employeproject.model.EmployeeBean;
import com.ibm.rest.apis.employeproject.model.ExceptionModel;
import com.ibm.rest.apis.employeproject.service.EmployeeService;

@Path("employee")


public class EmployeeResourceHandler {
	
	EmployeeService employeeService = new EmployeeService();
	
	/*@GET
	 * 
	 * 
	 * 	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getMessages() {
		System.out.println("Get Called");
		return employeeService.getAllEmployees();
	}
	
	*/
	
	
	
	// GET HTTP Method Example
	// Sending Response using GenericEntity
	// URL Example
	// http://localhost:8080/employeproject/empinventory/employee
		
	
	/*@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMessages() {
		System.out.println("Get Called");
		
		 GenericEntity<List<Employee>> entity = 
		            new GenericEntity<List<Employee>>(employeeService.getAllEmployees()) {};
		return Response
					.accepted(entity)
					//.status(Status.FOUND)
					.build();
		
	}
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	

	// POST HTTP Method Example - How to send Response using Response Class
	// Adding new Employee Resource
	// URL Example
	// http://localhost:8080/employeproject/empinventory/employee
		
	/*@POST
	@Produces ({MediaType.TEXT_PLAIN ,MediaType.APPLICATION_JSON})
	@Consumes ({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
		
	public Response addEmp(@Context UriInfo uri, Employee emp) {
		Employee newemp = employeeService.addEmployee(emp);
		URI u = uri.getAbsolutePathBuilder().path(newemp.getId()+"").build();
		System.out.println(u);
		
		ResponseBuilder rb = Response.created(u);
		rb.entity(newemp);
		rb.status(Status.CREATED);
		Response rs = rb.build();
		return rs;
	}*/
	
	
	
	
	// GET HTTP Method Example - How to send Response using Response Class
	// Adding new Employee Resource
	// URL Example
	// http://localhost:8080/employeproject/empinventory/employee
		
	
	
	/*@GET
	@Produces ({MediaType.TEXT_PLAIN ,MediaType.APPLICATION_JSON})
	@Consumes ({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
	
	public Response getEmployeeDetails() {
		
		List <Employee> empList = employeeService.getAllEmployees();
		
		GenericEntity <List<Employee>>  empEntiesinArray = null;
		
		
		empEntiesinArray = new GenericEntity<List<Employee>>(empList) {};
		
		return Response.accepted(empEntiesinArray)
						.status(Status.FOUND)
						.build();
		
		
	}
	
	*/
	
	
	
	@GET
	@Produces ({MediaType.TEXT_PLAIN ,MediaType.APPLICATION_JSON})
	@Consumes ({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
	
	public Response getEmployeeDetails(@QueryParam ("year") long year) {
		
		if (year == 0 ) {
		
			ErrorMessage message = new ErrorMessage("Hello You have passed invalid year", "http://yahoo.com", 1002, "GetEmployeeDetails()");
			
			ResponseBuilder resb = Response.accepted(message);
							resb.status(Status.BAD_REQUEST);
			Response response =		resb.build();
			throw new WebApplicationException(response);
		}
		else {
		
		List <Employee> empList = employeeService.getAllEmployees();
		
		GenericEntity <List<Employee>>  empEntiesinArray = null;
		
		
		empEntiesinArray = new GenericEntity<List<Employee>>(empList) {};
		
		return Response.accepted(empEntiesinArray)
						.status(Status.FOUND)
						.build();
		
		}
	}
	
	
	
	
	// PUT HTTP Method Example
	// Update Employee Resource details by Map Key ID as Search Cretria
		
	@PUT
	@Path ("/{id}")
	@Produces (MediaType.APPLICATION_JSON)
	@Consumes (MediaType.APPLICATION_JSON)

	
	public Employee updateEmployee(@PathParam ("id") long id, Employee emp) {
		emp.setId(id);
			return employeeService.updateEmployeeDetails(emp);
	}
	
	// DELETE HTTP Method Example
	// Delete Employee Resource details by Map Key ID as Search Cretria
		
	
	@DELETE
	
	@Path ("/{id}")
	public Employee deleteEmp(@PathParam ("id") long id) {
		
		System.out.println("Delete Called" + id);
	
		return employeeService.removeEmployeeDetails(id);
	}
	
	
	
	
	
	// GET HTTP Method Example using Query Parameter Annotation
	// Search and Return Employee Results based on Query Parameter Search Cretria
	// URL Example
	// http://localhost:8080/employeproject/empinventory/employee?year=2018
	// http://localhost:8080/employeproject/empinventory/employee
	// http://localhost:8080/employeproject/empinventory/employee?start=9&size=3
		
	/*	
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	@Consumes (MediaType.APPLICATION_JSON)
	public List<Employee> getEmployeeList(@QueryParam ("year") int year, @QueryParam ("start") int start, @QueryParam ("size") int size)  
	{
		 if (start >0 &  size >0){
			
			
				return employeeService.getAllEmployeePaginated(start, size);
				}
			
		
		else {
				if (year >0) {
		
		
			return employeeService.getAllEmployeeForDOJYear(year);
				}
				else
				{
				return	employeeService.getAllEmployees();
				}
		}
		
	
	}
	*/

	


	// GET HTTP Method Example using Matrix Parameter Annotation
	// Search and Return Employee Results based on Matrix Parameter Search Cretria
	// URL Example 
	// http://localhost:8080/employeproject/empinventory/employee;year=2018
	// http://localhost:8080/employeproject/empinventory/employee;size=3;start=1
	// http://localhost:8080/employeproject/empinventory/employee
	

	/*
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	@Consumes (MediaType.APPLICATION_JSON)
	public List<Employee> getEmployeeListUsingMatrixParam(@MatrixParam ("year") int year, @MatrixParam ("start") int start, @MatrixParam ("size") int size)  
	{
		System.out.print("Insite getEmployeeListUsingMatrixParam" );
		 if (start >0 &  size >0){
				
				
				return employeeService.getAllEmployeePaginated(start, size);
				}
			
		
		else {
				if (year >0) {
		
		
			return employeeService.getAllEmployeeForDOJYear(year);
				}
				else
				{
				return	employeeService.getAllEmployees();
				}
		}
	}
	*/
	
	

	// GET HTTP Method Example using Header Parameter Annotation
	// Search and Return Employee Results based on Header Parameter Search Cretria
	// URL Example 
	// Please pass value in headers in PostMan 
	// http://localhost:8080/employeproject/empinventory/employee
	

	/*
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	@Consumes (MediaType.APPLICATION_JSON)
	public List<Employee> getEmployeeListUsingHeaderParam(@HeaderParam ("year") int year, @HeaderParam ("start") int start, @HeaderParam ("size") int size)  
	{
		System.out.print("Insite getEmployeeListUsingMatrixParam" );
		 if (start >0 &  size >0){
				
				
				return employeeService.getAllEmployeePaginated(start, size);
				}
			
		
		else {
				if (year >0) {
		
		
			return employeeService.getAllEmployeeForDOJYear(year);
				}
				else
				{
				return	employeeService.getAllEmployees();
				}
		}
	}
	*/
	
	
	
		// GET HTTP Method Example using Cookies Parameter Annotation
		// Search and Return Employee Results based on Matrix Parameter Search Cretria
		// URL Example 
		// Please pass value in Cookies in PostMan 
		// http://localhost:8080/employeproject/empinventory/employee
		

		/*
		@GET
		@Produces (MediaType.APPLICATION_JSON)
		@Consumes (MediaType.APPLICATION_JSON)
		public List<Employee> getEmployeeListUsingCookieParam(@CookieParam ("year") int year, @CookieParam ("start") int start, @CookieParam ("size") int size)  
		{
			System.out.print("Insite getEmployeeListUsingCookieParam" );
			 if (start >0 &  size >0){
					
					
					return employeeService.getAllEmployeePaginated(start, size);
					}
				
			
			else {
					if (year >0) {
			
			
				return employeeService.getAllEmployeeForDOJYear(year);
					}
					else
					{
					return	employeeService.getAllEmployees();
					}
			}
		}
		
	*/
	
	
	

	// GET HTTP Method Example using Context Parameter Annotation
	// Search and Return Employee Results based on Context Query Parameter Search Cretria
	// URL Example 
	// http://localhost:8080/employeproject/empinventory/employee?year=2018
	

	/*
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	@Consumes (MediaType.APPLICATION_JSON)
	public void getEmployeeListUsingContextParam(@Context UriInfo uriDetails)  
	{
	
		System.out.println(uriDetails.getAbsolutePath());
		System.out.println("ALL query parameters -- "+ uriDetails.getQueryParameters().toString());
	    System.out.println("'year' query parameter -- "+ uriDetails.getQueryParameters().get("year"));
	    System.out.println("Complete URI -- "+ uriDetails.getRequestUri());
		
		
	}
	
	  */

		// GET HTTP Method Example using Context Parameter Annotation
		// Search and Return Employee Results based on Context Header Parameter Search Cretria
		// URL Example 
		// http://localhost:8080/employeproject/empinventory/employee
		
	 /*
		
		@GET
		@Produces (MediaType.APPLICATION_JSON)
		@Consumes (MediaType.APPLICATION_JSON)
		public void getEmployeeListUsingContextParamHeader(@Context HttpHeaders headers)  
		{
			 	System.out.println("ALL headers -- "+ headers.getRequestHeaders().toString());
			 	
			 	System.out.println("'Accept' header -- "+ headers.getHeaderString("Accept"));
			 //	System.out.println("'TestCookie' value -- "+ headers.getCookies().get("TestCookie").getValue());
				
		}
		
	
	*/
	


	// GET HTTP Method Example using Bean Parameter Annotation
	// 
	// URL Example 
	// http://localhost:8080/employeproject/empinventory/employee?year=start
	
 
	/*
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	@Consumes (MediaType.APPLICATION_JSON)
	public void getEmployeeListUsingContextParamHeader(@BeanParam EmployeeBean queryBean)  
	{
		 	System.out.println("Size  -- "+ queryBean.getSize());
		 	System.out.println("Size  -- "+ queryBean);
		 	System.out.println("Start -- "+ queryBean.getStart());
	}
	 */
	

	// GET HTTP Method Example using Bean Parameter Annotation
	// 
	// URL Example 
	// http://localhost:8080/employeproject/empinventory/employee?year=start
	
 
	
	/*@POST
	@Produces ({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN,})
	@Consumes (MediaType.APPLICATION_FORM_URLENCODED)
	public String getEmployeeListUsingContextParamHeader(@FormParam ("year") int year[], @FormParam ("year") int start, @FormParam ("size") int size)  
	{
		
		
		return "Sureh";
		
	}
	
 */
	
	
}
	


	
	


