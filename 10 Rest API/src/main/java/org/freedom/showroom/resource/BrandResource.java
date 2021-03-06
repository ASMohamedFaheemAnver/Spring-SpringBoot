package org.freedom.showroom.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLEngineResult.Status;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.freedom.showroom.model.Brand;
import org.freedom.showroom.model.Link;
import org.freedom.showroom.service.BrandService;

@Path("/showroom")
public class BrandResource {

	BrandService brandService = new BrandService();

	@GET
	@Path("/get-brands")
	// @Produces(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Brand> getBrands() {
		List<Brand> listOfBrands = brandService.getBrands();
		return listOfBrands;
	}

	@GET
	@Path("/get-brand/{brandId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Brand getBrand(@PathParam("brandId") int brandId, @Context UriInfo uriInfo) {
		Brand brand = brandService.getBrand(brandId);
		Link selfLink = new Link(uriInfo.getAbsolutePath().toString(), "self");
//		Link productsLink = new Link(
//				uriInfo.getAbsolutePathBuilder().path("products").build().toString().replaceAll("get-", ""),
//				"products");

		String productUri = uriInfo.getBaseUriBuilder().path(BrandResource.class)
				.path(BrandResource.class, "productDelegation").path(ProductResource.class, "getProductsByBrand")
				.resolveTemplate("brandId", brandId).toString();
		List<Link> links = new ArrayList<Link>();
		Link productsLink = new Link(productUri, "products");
		links.add(selfLink);
		links.add(productsLink);
		brand.setLinks(links);
		return brand;
	}

	@POST
	@Path("/set-brand")
	// @Consumes(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response setBrand(Brand brand, @Context UriInfo uriInfo) {
		brandService.addBrand(brand);
		// String url = uriInfo.getAbsolutePath().toString() + "/" +
		// brand.getBrand_id();
		URI location = URI.create(uriInfo.getAbsolutePathBuilder().path(BrandResource.class)
				.path(Integer.toString(brand.getBrand_id())).build().toString().replace("set", "get"));
		return Response.created(location).entity(brand).build();
	}

	@PUT
	@Path("/put-brand/{brandId}")
	// @Consumes(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_JSON)
	public void putBrand(@PathParam("brandId") int brandId, Brand updatedBrand) {
		updatedBrand.setBrand_id(brandId);
		brandService.updateBrand(updatedBrand);
	}

	@DELETE
	@Path("/delete-brand/{brandId}")
	// @Consumes(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteBrand(@PathParam("brandId") int brandId) {
		brandService.deleteBrand(brandId);
	}

	@Path("/brand")
	public ProductResource productDelegation() {
		return new ProductResource();
	}
}
