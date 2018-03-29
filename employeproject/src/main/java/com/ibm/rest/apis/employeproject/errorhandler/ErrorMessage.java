package com.ibm.rest.apis.employeproject.errorhandler;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class ErrorMessage {

		String message;
		String doclink;
		long errorCode;
		String source;
		
		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String getDoclink() {
			return doclink;
		}

		public void setDoclink(String doclink) {
			this.doclink = doclink;
		}

		public long getErrorCode() {
			return errorCode;
		}

		public void setErrorCode(long errorCode) {
			this.errorCode = errorCode;
		}

		public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
		}

		public ErrorMessage(String message, String doclink, long errorCode, String source) {
			this.message = message;
			this.doclink = doclink;
			this.errorCode = errorCode;
			this.source = source;
		}
		
		public ErrorMessage() {
			super();
			
		}
		
	
}
