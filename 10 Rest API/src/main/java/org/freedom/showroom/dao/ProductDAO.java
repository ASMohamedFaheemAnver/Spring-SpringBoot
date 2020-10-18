package org.freedom.showroom.dao;

import java.util.List;

import org.freedom.showroom.model.Brand;
import org.freedom.showroom.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProductDAO {

	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Product.class)
			.addAnnotatedClass(Brand.class).buildSessionFactory();

	public List<Product> getProductsByBrand(int brandId) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		String query = "from products where brand_id = '" + brandId + "'";
		return session.createQuery(query).getResultList();
	}

	public List<Product> getProductsByBrandAndCategory(int brandId, String category) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		String query = "from products where brand_id = '" + brandId + "' AND category = '" + category + "'";
		return session.createQuery(query).getResultList();
	}

}
