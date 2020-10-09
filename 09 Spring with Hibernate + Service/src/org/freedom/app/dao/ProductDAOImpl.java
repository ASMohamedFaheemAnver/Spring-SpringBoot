package org.freedom.app.dao;

import java.util.List;


import org.freedom.app.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	
	public List<Product> getProducts() {
		System.out.println("ProductDAOImpl, getProduct");
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Product> productQuery = currentSession.createQuery("from products", Product.class);
		List<Product> products = productQuery.getResultList();
		return products;
	}

	@Override
	public void addProduct(Product product) {
		System.out.println("ProductDAOImpl, addProduct");
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(product);
	}

}
