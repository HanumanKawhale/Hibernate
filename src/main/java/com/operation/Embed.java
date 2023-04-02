package com.operation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Embed {
	 public static void main(String[] args) {
		
		  Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
          
	        SessionFactory factory = cfg.buildSessionFactory();
	        
	        Student student = new Student();
	        student.setId(3);
	        student.setName("Tushar");
	        student.setCity("banglore");
	        
	        
	        Certificate cet= new Certificate();
	        cet.setCourse("java");
	        cet.setDuration("2 month");
	        
	        student.setCerti(cet);
	        
	        Session session= factory.openSession();
	        Transaction tx=session.beginTransaction();
	        
	        
	        //object
	        session.save(student);
	        
	        tx.commit();
	        session.close();
	        factory.close();
	}
}
