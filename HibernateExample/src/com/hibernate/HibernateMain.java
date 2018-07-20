package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.dto.Address;
import com.hibernate.dto.College;
import com.hibernate.dto.Company;
import com.hibernate.dto.UserDetails;

public class HibernateMain {

	public static void main(String[] args) {

		UserDetails user = new UserDetails();
		user.setUserName("paanduranga");
		Address address = new Address();
		address.setCity("Hyderabad");
		address.setCountry("India");
		address.setState("AP");
		address.setPin(521245);
		user.getAddress().add(address);

		College college = new College();
		college.setBranch("ECE");
		college.setName("RVR & JC");
		user.setCollege(college);
		college.setUser(user);

		College college2 = new College();
		college2.setBranch("EEE");
		college2.setName("VRV");

		user.setCollege(college2);

		college2.setUser(user);

		Company company1 = new Company();
		company1.setCompanyLocation("Hyderabad");
		company1.setCompanyName("PRAMATI");

		Company company2 = new Company();
		company2.setCompanyLocation("Bangalore");
		company2.setCompanyName("CISCO");

		UserDetails user2 = new UserDetails();
		user2.getAddress().add(address);
		user2.setUserName("Divya");
		user2.setCollege(college);
		user2.setCollege(college2);
		user2.getCompanies().add(company1);
		user2.getCompanies().add(company2);
		
		user.getCompanies().add(company1);
		user.getCompanies().add(company2);

		company1.getUsers().add(user);
		company2.getUsers().add(user);
		company1.getUsers().add(user2);
		company2.getUsers().add(user2);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(college);
		session.save(college2);
		session.save(company1);
		session.save(company2);
		session.save(user2);
		session.getTransaction().commit();
		session.close();

		/*
		 * session = sessionFactory.openSession(); session.beginTransaction(); user =
		 * (UserDetails) session.get(UserDetails.class, 1); session.close();
		 * System.out.println(user.getAddress().size());
		 */
	}

}
