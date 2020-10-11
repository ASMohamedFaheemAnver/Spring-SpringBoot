package org.freedom.app.service;

import java.util.List;

import org.freedom.app.dao.ProductDAO;
import org.freedom.app.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppServiceImpl implements AppService{
	@Autowired
	private ProductDAO productDAO;
	
	@Override
	@Transactional
	public List<Product> getProducts() {
		return productDAO.getProducts();
	}

	@Override
	@Transactional
	public void addProduct(Product product) {
		productDAO.addProduct(product);
		
	}

	@Override
	@Transactional
	public Product getProduct(int product_id) {
		return productDAO.getProduct(product_id);
	}

	@Override
	@Transactional
	public void deleteProduct(int product_id) {
		productDAO.deleteProduct(product_id);
		
	}

}
