package org.freedom.showroom.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/showroom")
public class Brands {
	@GET
	@Path("/get-brands")
	@Produces(MediaType.TEXT_PLAIN)
	public String getBrands() {
		return "list of brands!";
	}
	
	@POST
	@Path("/set-brand")
	@Produces(MediaType.TEXT_PLAIN)
	public String setBrand() {
		return "Brand was set!";
	}
	
	@PUT
	@Path("/put-brand/{brandId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String putBrand(@PathParam("brandId") int brandId) {
		return "Brand with id " + brandId + "  was updated!";
	}
	
	@DELETE
	@Path("/delete-brand/{brandId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteBrand(@PathParam("brandId") int brandId) {
		return "Brand with id " + brandId + " was deleted!";
	}
}
