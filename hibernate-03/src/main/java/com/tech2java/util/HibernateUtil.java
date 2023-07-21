package com.tech2java.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	
	//private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;
	  
    
	/*
	 * another way
	private static SessionFactory buildSessionFactory1() {
        try {
        	Configuration configuration=new Configuration();
        	//configuration.configure("custom.cfg.xml");
        	//configuration.addResource("Customer.hbm.xml");
        	//configuration.addAnnotatedClass(Customer.class);
        	ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        	return configuration.buildSessionFactory(serviceRegistry);
            		//.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("build SeesionFactory failed :" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
  
	
	  public static SessionFactory getSessionFactory() { 
		  return sessionFactory; 
	   }
	 */
  
    public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				// Create registry
				registry = new StandardServiceRegistryBuilder().configure().build();

				// Create MetadataSources
				MetadataSources sources = new MetadataSources(registry);

				// Create Metadata
				Metadata metadata = sources.getMetadataBuilder().build();

				// Create SessionFactory
				sessionFactory = metadata.getSessionFactoryBuilder().build();

			} catch (Exception e) {
				e.printStackTrace();
				if (registry != null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
			}
		}
		return sessionFactory;
	}

	public static void shutdown() {
		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
    
}
