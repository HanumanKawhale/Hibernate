package com.mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Map {
	
	public static void main(String[] args) {
		
	     Configuration cfg = new Configuration().configure("com/mapping/hibernate.cfg.xml");
         
	        SessionFactory factory = cfg.buildSessionFactory();
	        
	        //
	        Question q1= new Question();
	        q1.setQuestion_id(11);
	        q1.setQuestion("what is c++?");
	        
	        Answer a1=new Answer();
	        a1.setAnswer_Id(222);
	        a1.setAnswer("programming");
	        
	        Answer a2 = new Answer();
	        a2.setAnswer_Id(333);
	        a2.setAnswer("language");
	        
	        List<Answer> answer = new ArrayList<Answer>();
	        answer.add(a1);
	        answer.add(a2);
	        
	        q1.setAnswer(answer);
	        
	   
	        Session s = factory.openSession();
	        Transaction tx = s.beginTransaction();
	        
//	        
//	        s.save(q1);
//	        s.save(a1);
//	        s.save(a2);
//	        
	        
	        Question q = (Question)s.get(Question.class,11);
	        
	        for (Answer a:q.getAnswer()) { 
             
	        	System.out.println(a.getAnswer());}
	        tx.commit();
	        
	        
	        factory.close();
		
	}
}
