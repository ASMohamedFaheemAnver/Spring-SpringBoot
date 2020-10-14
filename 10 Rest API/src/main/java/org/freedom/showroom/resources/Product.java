package org.freedom.showroom.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.freedom.showroom.hibernate.entity.ProductEntity;
import org.freedom.showroom.services.ProductService;

public class Product {
	ProductService productService = new ProductService();

	@GET
	@Path("/{brandId}/products")
	// @Produces(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProductEntity> getProductsByBrand(@PathParam("brandId") int brandId,
			@QueryParam("category") String category) {
		List<ProductEntity> listOfProducts;
		if( (category != null) && (category.equals("bike") || category.equals("car"))) {
			listOfProducts = productService.getProductsByBrandAndCategory(brandId, category);
			return listOfProducts;
		}else {
			listOfProducts = productService.getProductsByBrand(brandId);
			return listOfProducts;
		}
		
	}
}