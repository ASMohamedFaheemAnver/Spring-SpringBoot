package org.freedom.showroom.resources;

import javax.servlet.ServletContext;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class HorCParam {
//	@Context
//	private UriInfo uriInfo;
//	
//	@Context
//	private ServletContext servletContext;

	@GET
	public String useFulAnnotations(@HeaderParam("Authorization") String token, @CookieParam("Cookie") String cookie) {
		return "GET / with token|cookie : " + token + "|" + cookie;
	}

	@GET
	@Path("/context")
	public String getContext(@Context HttpHeaders header) {
//		return "Absolute path : " +  uriInfo.getAbsolutePath().toString();

		return header.getRequestHeaders().keySet().toString();
	}
}
