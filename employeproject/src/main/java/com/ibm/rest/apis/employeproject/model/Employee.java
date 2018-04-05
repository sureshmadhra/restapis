package com.ibm.rest.apis.employeproject.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.ibm.rest.apis.employeproject.database.*;

@XmlRootElement

public class Employee {

	String name, address;
	long empid;
	Date doj;
	transient long id;
	
	List <Link> links = new ArrayList();
	
	private Map<Long, Department> departments = new HashMap<>();
	
	
	//@XmlTransient
	public Map<Long, Department> getDepartments() {
		return departments;
	}

	

	public void setDepartments(Map<Long, Department> departments) {
		this.departments = departments;
	}

	

	
	public long getId() {
		return id;
	}

	public List<Link> getLinkRepo() {
		return links;
	}

	public void setLinkRepo(List<Link> link) {
		this.links = link;
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

	
	
	public void addLink(String url, String rel) {
		Link link = new Link(url,rel);
		link.setLink(url);
		link.setRelation(rel);
		links.add(link);
	}


}




