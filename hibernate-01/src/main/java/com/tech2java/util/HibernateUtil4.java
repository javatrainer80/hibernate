package com.tech2java.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//Custom hibernate properties file name instead hibernate.properties
public class HibernateUtil4 {

	
	private static final SessionFactory sessionFactory = buildSessionFactory();
	  
	private static SessionFactory buildSessionFactory() {
        try {
            Properties properties = new Properties();
            properties.load(HibernateUtil4.class.getClassLoader().getResourceAsStream("hebernate-dev.properties"));
            
            return new Configuration()
                .addProperties(properties)
                //.addPackage("com.java2learn.domain")
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
