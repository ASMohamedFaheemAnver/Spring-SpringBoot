package org.freedom.hibernate;

import org.freedom.hibernate.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		// The configuration factory xml file name is not mandatory to specify since
		// this is the default name but I am mentioning this to make it clear for the
		// first time
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			User user = new User("user_name", "password", "first_name", "last_name");
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			System.out.println("Row data added!");
		}finally {
			session.close();
			factory.close();
		}
	}
}
