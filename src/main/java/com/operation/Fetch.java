package com.operation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Fetch {
	
	public static void main(String[] args) {
		
	
	
	   Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
       
       SessionFactory factory = cfg.buildSessionFactory();
       
       Session session  = factory.openSession();
       
       //get 
       Student student = (Student)session.get(Student.class, 1);
       System.out.println(student);
       System.out.println(student.getCity()); 
       
       Student student1 = (Student)session.load(Student.class, 1);
       System.out.println(student1);
       
       
       
       session.close();
       factory.close();

	}

	
}	