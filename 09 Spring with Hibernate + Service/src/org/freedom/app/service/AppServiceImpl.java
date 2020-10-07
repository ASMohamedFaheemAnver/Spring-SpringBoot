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

}
