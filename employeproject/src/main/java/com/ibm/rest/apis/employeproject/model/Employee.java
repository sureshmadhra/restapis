package com.ibm.rest.apis.employeproject.model;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class Employee {

	String name, address;
	long empid;
	Date doj;
	transient long id;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Employee(String name, String address, long empid,  long id) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.empid = empid;
		doj = new Date();
	}
	
	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public Employee() {
		
	}
	
	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getEmpid() {
		return empid;
	}
	public void setEmpid(long empid) {
		this.empid = empid;
	}

	
	
	

}




