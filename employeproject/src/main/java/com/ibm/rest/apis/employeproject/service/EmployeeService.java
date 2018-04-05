package com.ibm.rest.apis.employeproject.service;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.UriInfo;

import java.util.Calendar;



import com.ibm.rest.apis.employeproject.database.DatabaseClass;
import com.ibm.rest.apis.employeproject.model.Employee;
public class EmployeeService {

	private Map<Long, Employee> emplList = DatabaseClass.getEmployeesMap();
	
	public EmployeeService() {
	//	emplList.put(1L, new Employee("Suresh", "Delhi" , 101001,1L));
	//	emplList.put(2L, new Employee("Rakesh", "Chennai" , 1023,2L));
	}

	public List<Employee> getAllEmployees() {
		return new ArrayList<Employee>(emplList.values()); 
	}
	
	
	public Employee getEmployeebyId(long id) {
		return emplList.get(id);
	}
	
	
	public Employee addEmployee(Employee emp, UriInfo uri) {
		emp.setId(emplList.size() + 1);
		emp.setDoj(new Date());
		System.out.println(uri.getRequestUri());
		System.out.println(uri.getBaseUri());
		String resourceURI = uri.getAbsolutePathBuilder().path(emp.getId()+"").toString();
		
		emp.addLink(resourceURI, "self");
		emplList.put(emp.getId(), emp);
		
		return emp;
	}
	
	public Employee updateEmployeeDetails(Employee emp) {
		if (emp.getId() <= 0) {
			System.out.println("Inside null");
			return null;
		}
		System.out.println(emp);
		emplList.put(emp.getId(), emp);
		return emp;
	}
	
	

	public Employee removeEmployeeDetails(long id) {
		return emplList.remove(id);
	}
	
	
	public List<Employee> getAllEmployeeForDOJYear(int year) {
		List<Employee> empListYear = new ArrayList<>();
		
		Calendar cal = Calendar.getInstance();
		
		
		for (Employee emp : emplList.values()) {
			cal.setTime(emp.getDoj());
			if (cal.get(Calendar.YEAR) == year) {
				empListYear.add(emp);
			}
		}
		return empListYear;
	}

	public List<Employee> getAllEmployeePaginated(int start, int size) {
		ArrayList<Employee> list = new ArrayList<Employee>(emplList.values());
		if (start + size > list.size()) {
			return new ArrayList<Employee>();
		}
		else {
			
		
		return list.subList(start, start + size);
		
		} 
	}
	

}









	
	
	

	
	
	
	
	
	
	
	
	
	
	

	
