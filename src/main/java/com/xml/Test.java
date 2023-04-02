package com.xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		
		Person person= new Person();
		person.setAddress("pune");
		person.setId(111);
		person.setName("Hanuman");
		person.setPhone("87888778");
		Session session = factory.openSession();	
		
		Transaction tx=session.beginTransaction();
		
		session.save(person);
		
		tx.commit();
		session.close();
		
	}

}
