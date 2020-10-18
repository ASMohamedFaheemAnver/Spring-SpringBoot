package org.freedom.showroom.dao;

import java.util.List;

import org.freedom.showroom.model.Brand;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BrandDAO {

	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Brand.class)
			.buildSessionFactory();

	public List<Brand> getBrands() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		return session.createQuery("from brands").getResultList();
	}

	public void addBrand(Brand brand) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(brand);
		session.getTransaction().commit();
	}

	public void updateBrand(Brand updatedBrand) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Brand brand = session.get(Brand.class, updatedBrand.getBrand_id());
		brand.setBrand_name(updatedBrand.getBrand_name());
		session.getTransaction().commit();
	}

	public void deleteBrand(int brandId) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Brand brand = session.get(Brand.class, brandId);
		session.delete(brand);
		session.getTransaction().commit();
	}

	public Brand getBrand(int brand_id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		return session.get(Brand.class, brand_id);
	}

}
