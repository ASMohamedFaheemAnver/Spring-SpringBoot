package org.freedom.showroom.resource;

import javax.servlet.ServletContext;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.freedom.showroom.model.ErrorPayload;

import com.sun.research.ws.wadl.Response;

@Path("/")
public class HorCParamResource {
//	@Context
//	private UriInfo uriInfo;
//	
//	@Context
//	private ServletContext servletContext;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String useFulAnnotations(@HeaderParam("Authorization") String token, @CookieParam("Cookie") String cookie) {
		return "GET / with token|cookie : " + token + "|" + cookie;
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	@Path("/context")
//	public String getContext(@Context HttpHeaders header) throws Exception {
	public String getContext(@HeaderParam("header") String header) throws Exception {
		// ErrorPayload error = new ErrorPayload(404, "Custom header not found!");
//		return "Absolute path : " +  uriInfo.getAbsolutePath().toString();
		// javax.ws.rs.core.Response response = javax.ws.rs.core.Response.status(404).entity(error).build();
		if (header == null) {
//			throw new Exception("Custom header not found!");
//			throw new WebApplicationException(response);
			throw new NotFoundException();
		}

		return header;
	}
}
