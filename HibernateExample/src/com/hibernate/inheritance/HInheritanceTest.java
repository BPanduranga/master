package com.hibernate.inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HInheritanceTest {

	public static void main(String[] args) {
		Fruit f = new Fruit();
		f.setName("fruit");

		Apple a = new Apple();
		
		a.setType("Apple");
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.persist(f);
		session.persist(a);
		
		session.getTransaction().commit();

		session.close();
	}

}
