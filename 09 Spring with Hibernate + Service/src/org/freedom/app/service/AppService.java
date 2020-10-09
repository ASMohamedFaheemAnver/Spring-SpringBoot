package org.freedom.app.service;

import java.util.List;

import org.freedom.app.entity.Product;

public interface AppService {
	List<Product> getProducts();

	void addProduct(Product product);
}
