package com.tech2java.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//Custom .cfg file
public class HibernateUtil2 {

	
	private static final SessionFactory sessionFactory = buildSessionFactory();
	  
	private static SessionFactory buildSessionFactory() {
        try {
           
            return new Configuration().configure("hibernate-dev.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("build SeesionFactory failed :" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
  
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
  
}
