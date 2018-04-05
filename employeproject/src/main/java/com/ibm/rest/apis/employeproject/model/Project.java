package com.ibm.rest.apis.employeproject.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement


//** Project Resource to hold project details


public class Project {

		String projectName;
		String projectDesc;
		long id;
		
		
		
		
		public Project() {
			super();
			
		}
		
		public Project(String projectName, String projectDesc, long id) {
			
			this.projectName = projectName;
			this.projectDesc = projectDesc;
			this.id = id;
		}
		
		
		public String getProjectName() {
			return projectName;
		}
		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}
		public String getProjectDesc() {
			return projectDesc;
		}
		public void setProjectDesc(String projectDesc) {
			this.projectDesc = projectDesc;
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		
		
		
		
		
}
