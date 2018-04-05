package com.ibm.rest.apis.employeproject.filter;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;

//import org.glassfish.jersey.internal.util.Base64;


//@Provider

public class SecurityFilter implements ContainerRequestFilter{

	public static final String AUTH_HEADER_KEY = "Authorization";
	
	public static final String AUTH_HEADER_PREFIX = "Basic";
	
	public static final String SECURITY_URL = "secure";
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		// TODO Auto-generated method stub
		
		if (requestContext.getUriInfo().getPath().contains(SECURITY_URL)) {
		
		List <String> authHeader = requestContext.getHeaders().get(AUTH_HEADER_KEY);
		
		
		if (authHeader != null && authHeader.size() > 0) {
			String authtoken = authHeader.get(0);
			authtoken = authtoken.replaceFirst(AUTH_HEADER_PREFIX, "");
			String decodeString = null;
			try {
				decodeString = new String(com.sun.org.apache.xml.internal.security.utils.Base64.decode(authtoken));
			} catch (Base64DecodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
							
			StringTokenizer token = new StringTokenizer(decodeString,";");
			String username = token.nextToken();
			
			String password = token.nextToken();
			
				if (username.equals("username") & password.equals("password")) {
					System.out.print("Secure");
					return;
				}
			
				Response response = Response
										.status (Status.UNAUTHORIZED)
										.entity("Unthorized Access")
										.build();
				requestContext.abortWith(response);
				
						
											
		}
		}
	}
	
	

}
