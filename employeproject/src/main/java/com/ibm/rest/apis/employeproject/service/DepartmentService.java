package com.ibm.rest.apis.employeproject.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.ibm.rest.apis.employeproject.database.DatabaseClass;
import com.ibm.rest.apis.employeproject.errorhandler.ErrorMessage;

import com.ibm.rest.apis.employeproject.model.Employee;
import com.ibm.rest.apis.employeproject.resource.DepartmentResourceHandler;
import com.ibm.rest.apis.employeproject.resource.EmployeeResourceHandler;
import com.ibm.rest.apis.employeproject.model.Department;

public class DepartmentService {
	
	private Map<Long, Employee> empList = DatabaseClass.getEmployeesMap();
	
	
	public List<Department> getAllDepartments(long employeeKeyId) {
		Map<Long, Department> departmentList = empList.get(employeeKeyId).getDepartments();
		return new ArrayList<Department>(departmentList.values());
	}
	
	
	public Department getDepartment(long employeeKeyId, long departmentId) {
		ErrorMessage errorMessage = new ErrorMessage("Not found","http://javabrains.koushik.org", 404, "Source");
		Response response = Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
		
		Employee message = empList.get(employeeKeyId);
		if (message == null) {
			throw new WebApplicationException(response);
		}
		Map<Long, Department> departments = empList.get(employeeKeyId).getDepartments();
		Department department = departments.get(departmentId);
		if (department == null) {
			throw new WebApplicationException(response);
		}
		return department;
	}
	
	public Department addDepartment(long employeeKeyId, Department department, UriInfo uriInfo) {
		Map<Long, Department> departmentList = empList.get(employeeKeyId).getDepartments();
		department.setDepartmentID(departmentList.size() + 1);
		departmentList.put(department.getDepartmentID(), department);
		
		Employee emp = empList.get(employeeKeyId);
		
		//System.out.println(uriInfo.getRequestUriBuilder().path(ing());
		
		
		URI uri = uriInfo.getRequestUriBuilder().path(department.getDepartmentID()+"")
									.build();
		emp.addLink(uri.toString(), "Department");
		
		return department;
	}
	
	public Department updateDepartmentDetails(long employeeKeyId, Department department) {
		Map<Long, Department> departmentList = empList.get(employeeKeyId).getDepartments();
		if (department.getDepartmentID() <= 0) {
			return null;
		}
		departmentList.put(department.getDepartmentID(), department);
		return department;
	}

	
	public Department removeDepartment(long employeeKeyId, long departmentId) {
		Map<Long, Department> departments = empList.get(employeeKeyId).getDepartments();
		return departments.remove(departmentId);
	}
	
	
	
}













	

