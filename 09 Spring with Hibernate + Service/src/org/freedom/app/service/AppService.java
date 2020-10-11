package org.freedom.app.service;

import java.util.List;

import org.freedom.app.entity.Product;

public interface AppService {
	List<Product> getProducts();

	void addProduct(Product product);

	Product getProduct(int product_id);

	void deleteProduct(int product_id);
}
