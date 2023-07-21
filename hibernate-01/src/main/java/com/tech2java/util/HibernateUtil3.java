package com.tech2java.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tech2java.entity.Customer;

//hibernate.properties instead cfg.xml file
public class HibernateUtil3 {

	
	private static final SessionFactory sessionFactory = buildSessionFactory();
	  
	private static SessionFactory buildSessionFactory() {
        try {
       
            return new Configuration()
                        // can also use .addPackage("com.java2learn.hibernate") to configure all models
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("build SeesionFactory failed :" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
  
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
  
    public static void close() {
        // Close all cached and active connection pools
        getSessionFactory().close();
    }
}
