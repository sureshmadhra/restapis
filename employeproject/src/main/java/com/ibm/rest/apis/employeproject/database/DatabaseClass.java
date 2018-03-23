package com.ibm.rest.apis.employeproject.database;

import java.util.HashMap;
import java.util.Map;
import com.ibm.rest.apis.employeproject.model.Employee;

public class DatabaseClass {

	private static Map<Long, Employee> employeesMap = new HashMap<>();
	
	public static Map<Long, Employee> getEmployeesMap() {
		return employeesMap;
	}

}




