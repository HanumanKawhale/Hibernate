package com.operation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "start" );
        
        
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
          
        SessionFactory factory = cfg.buildSessionFactory();
        
        Student student = new Student();
        student.setId(1);
        student.setCity("pune");
        student.setName("Hanuman");
        
        
        //
        Address address= new Address();
        address.setCity("mumbai");
        address.setStreet("Street2");
        address.setOpen(true);
        address.setAddDate(new Date());
        address.setD(123.33);
        
        //reading image
       
			FileInputStream fis = new FileInputStream("src/main/java/t.png.jpg");
			
			byte[] data = new byte[fis.available()];
			
			fis.read(data);
			address.setImage(data);
	
        System.out.println(student);
        
        Session session = factory.openSession();
        
        Transaction  tx=  session.beginTransaction();
        
        session.save(student);
        session.save(address);
        
        tx.commit();
        
        
        
        session.close();
    }
}
