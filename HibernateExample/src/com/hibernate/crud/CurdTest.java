package com.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;

public class CurdTest {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Employee e = (Employee) session.get(Employee.class,	5);
		e.setName("Updated emp without update");
		//session.update(e);

		session.getTransaction().commit();
		session.close();
		
		System.out.println(e.getName());

	}

}
