package com.tech2java.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tech2java.entity.Customer;
import com.tech2java.util.HibernateUtil5;



public class Client {

	public static void main(String[] args) {
		
		
		try (SessionFactory sessionFactory = HibernateUtil5.getSessionFactory()) {

			Session session = sessionFactory.openSession();
			Transaction tx=session.beginTransaction();

			//Create Customer Object
			Customer customer=new Customer();
			customer.setCustomerId(303);
			customer.setCustomerName("Rahul");
			customer.setCustomerAge(34);
			customer.setCustomerAddress("HYD");

			session.save(customer);
			
			tx.commit();
			System.out.println("Employee object saved successfully....");
			
		} catch (Exception ex) {
			System.err.println("Exception occured...."+ex.toString());
		}
		
		
	}
}
