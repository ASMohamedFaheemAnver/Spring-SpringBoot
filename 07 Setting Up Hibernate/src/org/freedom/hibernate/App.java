package org.freedom.hibernate;

import java.util.List;

import org.freedom.hibernate.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		writeUsingORM();
	}

	// Will used to write database
	public static void writeUsingORM() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			User user = new User("user_name", "password", "first_name", "last_name");
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			System.out.println("Row data added!");
		} finally {
			session.close();
			factory.close();
		}
	}

	// Will used to retrieve data
	public static void retrieveUsingORM() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			User user = new User();
			session.beginTransaction();
			user = session.get(User.class, 1);
			System.out.println(user);
		} finally {
			session.close();
			factory.close();
		}
	}

	// Will used to update data
	public static void updateUsingORM() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			User user = new User();
			session.beginTransaction();
			user = session.get(User.class, 1);
			user.setUser_name("adming@freedom.org");
			session.getTransaction().commit();
			System.out.println(user);
		} finally {
			session.close();
			factory.close();
		}
	}

	// Will used to delete data
	public static void deleteUsingORM() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			User user = new User();
			session.beginTransaction();
			user = session.get(User.class, 2);
			session.delete(user);
			session.getTransaction().commit();
			System.out.println(user);
		} finally {
			session.close();
			factory.close();
		}
	}
	
	// Listing out database
		public static void listingOutDataUsingORM() {
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
					.buildSessionFactory();

			Session session = factory.getCurrentSession();

			try {
				session.beginTransaction();
				
				List<User> users = session.createQuery("from users").getResultList();
				
				for(User user: users) {
					System.out.println(user);
				}
				
			} finally {
				session.close();
				factory.close();
			}
		}

}
