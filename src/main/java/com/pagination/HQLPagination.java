package com.pagination;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.operation.Student;



public class HQLPagination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg= new Configuration();
		cfg.configure();
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Query query= session.createQuery("from Student");
		
		query.setFirstResult(0);
		query.setMaxResults(2);
		
		List<Student> list = query.list();
		
		for(Student st:list) {
			
			System.out.println(st.getName());
		}
		
		
		
		factory.close();
	}

}
