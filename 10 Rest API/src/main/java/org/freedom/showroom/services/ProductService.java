package org.freedom.showroom.services;

import java.util.List;

import org.freedom.showroom.hibernate.dao.ProductDAO;
import org.freedom.showroom.hibernate.entity.ProductEntity;

public class ProductService {
	
	ProductDAO productDAO = new ProductDAO();

	public List<ProductEntity> getProductsByBrand(int brandId) {
		return productDAO.getProductsByBrand(brandId);
	}

}
