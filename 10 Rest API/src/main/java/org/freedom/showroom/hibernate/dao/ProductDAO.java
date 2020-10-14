package org.freedom.showroom.hibernate.dao;

import java.util.List;

import org.freedom.showroom.hibernate.entity.BrandEntity;
import org.freedom.showroom.hibernate.entity.ProductEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProductDAO {

	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(ProductEntity.class)
			.addAnnotatedClass(BrandEntity.class).buildSessionFactory();

	public List<ProductEntity> getProductsByBrand(int brandId) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		String query = "from products where brand_id = '" + brandId + "'";
		return session.createQuery(query).getResultList();
	}

	public List<ProductEntity> getProductsByBrandAndCategory(int brandId, String category) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		String query = "from products where brand_id = '" + brandId + "' AND category = '" + category + "'";
		return session.createQuery(query).getResultList();
	}

}
