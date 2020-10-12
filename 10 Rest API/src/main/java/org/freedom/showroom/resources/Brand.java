package org.freedom.showroom.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.freedom.showroom.hibernate.entity.BrandEntity;
import org.freedom.showroom.services.BrandService;

@Path("/showroom")
public class Brand {

	BrandService brandService = new BrandService();

	@GET
	@Path("/get-brands")
	// @Produces(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public List<BrandEntity> getBrands() {
		List<BrandEntity> listOfBrands = brandService.getBrands();
		return listOfBrands;
	}

	@POST
	@Path("/set-brand")
	//@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public void setBrand(BrandEntity brand) {
		brandService.addBrand(brand);
	}

	@PUT
	@Path("/put-brand/{brandId}")
	//@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public void putBrand(@PathParam("brandId") int brandId, BrandEntity updatedBrand) {
		updatedBrand.setBrand_id(brandId);
		brandService.updateBrand(updatedBrand);
	}

	@DELETE
	@Path("/delete-brand/{brandId}")
	//@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteBrand(@PathParam("brandId") int brandId) {
		brandService.deleteBrand(brandId);
	}
}
