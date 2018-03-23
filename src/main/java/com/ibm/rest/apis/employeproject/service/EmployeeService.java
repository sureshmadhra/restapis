package com.ibm.rest.apis.employeproject.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
	
	
	public Employee addEmployee(Employee emp) {
		emp.setId(emplList.size() + 1);
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
	
	
}


///





	
	
	
	
	
	
	
	
	
	
	

	
