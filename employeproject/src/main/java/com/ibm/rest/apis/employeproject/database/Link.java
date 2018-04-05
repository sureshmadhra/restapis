package com.ibm.rest.apis.employeproject.database;



public class Link {

	String link;
	String relation;
	public String getLink() {
		return link;
	}
	
	public Link(String link, String relation) {
		
		this.link = link;
		this.relation = relation;
	}
	
	
	public Link() {
		
	}
	
	public void setLink(String link) {
		this.link = link;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	
	
}
