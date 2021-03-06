package org.freedom.app.dao;

import java.util.List;

import org.freedom.app.entity.Product;

public interface ProductDAO {
	public List<Product> getProducts();

	public void addProduct(Product product);

	public Product getProduct(int product_id);

	public void deleteProduct(int product_id);
}
