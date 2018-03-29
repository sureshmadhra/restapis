package com.ibm.rest.apis.employeproject.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class ExceptionModel {

		int errorcode;
		String message;
		String docUrl;
		
		public ExceptionModel(int errorcode, String message,String docUrl) {
			
			this.errorcode = errorcode;
			this.message = message;
			this.docUrl = docUrl;
			
		}
		
		public ExceptionModel() {
			
			
			
		}
		
		
		public String getDocUrl() {
			return docUrl;
		}


		public void setDocUrl(String docUrl) {
			this.docUrl = docUrl;
		}


		public int getErrorcode() {
			return errorcode;
		}
		public void setErrorcode(int errorcode) {
			this.errorcode = errorcode;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		 
	
}
