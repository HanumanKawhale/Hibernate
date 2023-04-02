package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mapping.Answer;
import com.mapping.Question;

public class Cascade {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration cfg =new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
	
		Session session = factory.openSession();
		
		Question q1=new Question();
		q1.setQuestion("what is spring?");
		
		Answer a1= new Answer(234,"spring framework");
		Answer a2 =new Answer(345,"spring orm");
		Answer a3 = new Answer(567,"springjdbc");
		
		List<Answer> list = new ArrayList();
		list.add(a3);
		list.add(a2);
		list.add(a1);
		
		q1.setAnswer(list);

		Transaction tx =session.beginTransaction();
		session.save(q1);
		
	}

}
