package com.hibernate.association.test.dto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AssociationTestClass {

	public static void main(String[] args) {

		PCompany company = new PCompany();

		company.setCompanyName("Pramati Technologies Pvt Ind.");

		Branch branch = new Branch();
		branch.setBranchName("Hyderabad");
		branch.setCompany(company);

		Branch branch2 = new Branch();
		branch2.setBranchName("Bangalore");
		branch2.setCompany(company);

		Branch branch3 = new Branch();
		branch3.setBranchName("Chennai");
		branch3.setCompany(company);

		company.getBranches().add(branch);
		company.getBranches().add(branch2);
		company.getBranches().add(branch3);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.persist(company);
		
		session.getTransaction().commit();

		session.close();
		company = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		company = (PCompany) session.get(PCompany.class, 1);
		
		session.close();
		
		System.out.println(company.getCompanyName() + "   " + company.getBranches().size());

	}

}
