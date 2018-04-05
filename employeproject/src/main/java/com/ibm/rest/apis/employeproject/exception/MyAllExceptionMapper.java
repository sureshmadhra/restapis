package com.ibm.rest.apis.employeproject.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.ibm.rest.apis.employeproject.errorhandler.ErrorMessage;

@Provider

public class MyAllExceptionMapper implements ExceptionMapper <MyAllException>{

	@Override
	public Response toResponse(MyAllException arg0) {
		
		ErrorMessage message = new ErrorMessage("Hello You have passed invalid year", "http://yahoo.com", 1002, "GetEmployeeDetails()");
		ResponseBuilder resb = Response.accepted(message);
						resb.status(Status.BAD_REQUEST);
		Response response =		resb.build();
		return response;
	}
	

}
