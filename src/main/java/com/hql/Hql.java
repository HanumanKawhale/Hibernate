package com.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.operation.Student;

public class Hql {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		//HQL Qurey Syntex
		Session session = factory.openSession();		
		
		String query = "from Student where city=:x";
		
	    Query q= session.createQuery(query);
	    
	    q.setParameter("x","pune");
	   //
	    List<Student> list =  q.list();
	    
	    for(Student student :list) {
	    	System.out.println(student.getName() +" "+ student.getId());
	    }
		
	    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
	    Transaction tx= session.beginTransaction();
	    
//	    Query qq= session.createQuery("delete from Student where city=:p");
//	    
//	    qq.setParameter("p","pune");
//	    int n=qq.executeUpdate();
//	    System.out.println(n);
//	    
//	    
//	    
	    //update
        Query qqq =session.createQuery("update Student set city=:c where name=:n");
	    
	    qqq.setParameter("c","mumbai");
	    qqq.setParameter("n","Hanuman");
	    
	   int n =qqq.executeUpdate();
	   System.out.println(n);
	    
	    
	    
	    
	    tx.commit();
	    
	    
	    
	}
	
}
