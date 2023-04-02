package com.sql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class SQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Configuration cfg =new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
	
		Session session = factory.openSession();
		
		String query = "select * from student";
		
		NativeQuery n = session.createSQLQuery(query);
		
		List<Object[]> list = n.list();
		
		for(Object[] student : list) {
			
			System.out.println(Arrays.deepToString(student));
		}
	}

}
