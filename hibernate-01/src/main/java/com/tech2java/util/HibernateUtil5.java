package com.tech2java.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.tech2java.entity.Customer;

//Using Java Configuration instead of configuration files
public class HibernateUtil5 {

	
	private static final SessionFactory sessionFactory = buildSessionFactory();
	  
	private static SessionFactory buildSessionFactory() {
        try {
          
            Properties properties = new Properties();
            properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            properties.put(Environment.URL, "jdbc:mysql://localhost:3306/cis");
            properties.put(Environment.USER, "root");
            properties.put(Environment.PASS, "root");
            properties.put(Environment.FORMAT_SQL, "true");
            properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
            properties.put(Environment.SHOW_SQL, "true");
            properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
            //properties.put(Environment.HBM2DDL_AUTO, "create");
            properties.put(Environment.POOL_SIZE, "5");
           
            return new Configuration()
                .setProperties(properties)
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
    
}
