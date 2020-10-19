package org.freedom.showroom.service;

import java.util.List;

import org.freedom.showroom.dao.ProductDAO;
import org.freedom.showroom.model.Product;

public class ProductService {
	
	ProductDAO productDAO = new ProductDAO();

	public List<Product> getProductsByBrand(int brandId) {
		return productDAO.getProductsByBrand(brandId);
	}

	public List<Product> getProductsByBrandAndCategory(int brandId, String category) {
		return productDAO.getProductsByBrandAndCategory(brandId, category);
	}

}
