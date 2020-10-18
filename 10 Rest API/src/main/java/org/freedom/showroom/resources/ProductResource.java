package org.freedom.showroom.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.freedom.showroom.model.Product;
import org.freedom.showroom.services.ProductService;

public class ProductResource {
	ProductService productService = new ProductService();

	@GET
	@Path("/{brandId}/products")
	// @Produces(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProductsByBrand(@PathParam("brandId") int brandId,
			@QueryParam("category") String category, @QueryParam("start") int start, @QueryParam("size") int size) {
		List<Product> listOfProducts;
		if ((category != null)) {
			listOfProducts = productService.getProductsByBrandAndCategory(brandId, category);
		} else {
			listOfProducts = productService.getProductsByBrand(brandId);
		}

		if (start >= 0 && size > 0) {
			listOfProducts = listOfProducts.subList(listOfProducts.size() >= start ? start : listOfProducts.size(),
					listOfProducts.size() >= size ? size : listOfProducts.size());
		}

		return listOfProducts;

	}
}
