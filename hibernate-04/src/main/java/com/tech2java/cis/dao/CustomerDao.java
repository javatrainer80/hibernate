package com.tech2java.cis.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tech2java.cis.entity.Customer;
import com.tech2java.cis.util.HibernateUtil;

public class CustomerDao {
	
	static SessionFactory sessionFactory=null;
	
	static {
		sessionFactory=HibernateUtil.getSessionFactory();
	}
	
	public void saveCustomer(Customer customer) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		@SuppressWarnings("deprecation")
		Integer customerId=(Integer)session.save(customer);
		System.out.println("Customer object saved with ID::"+customerId);
		tx.commit();
		System.out.println("Customer object saved successfully....");
	}
	
	public void persistCustomer(Customer customer) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.persist(customer);
		tx.commit();
		System.out.println("Customer object saved successfully....");
	}
	
	@SuppressWarnings("deprecation")
	public Customer loadCustomer(Integer customerId) {
		Session session=sessionFactory.openSession();
		System.out.println("Before calling load method.");
		Customer customer=session.load(Customer.class, customerId);
		System.out.println("After calling load method.");
		
		System.out.println("Calling getCustomerName() method on returned customer object");
		
		System.out.println("customer object::"+customer.getCustomerName());
		return customer;
	}
	
	public Customer getCustomer(Integer customerId) {
		Session session=sessionFactory.openSession();
		System.out.println("Before calling load method.");
		Customer customer=session.get(Customer.class, customerId);
		System.out.println("After calling load method.");
		System.out.println("customer object::"+customer);
		return customer;
	}
	
	@SuppressWarnings("deprecation")
	public Customer deleteCustomer(Integer customerId) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Customer customer=session.get(Customer.class, customerId);
		session.delete(customer);
		tx.commit();
		System.out.println("customer object deleted::"+customerId);
		return customer;
	}
	
	public Customer removeCustomer(Integer customerId) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Customer customer=session.get(Customer.class, customerId);
		session.remove(customer);
		tx.commit();
		System.out.println("customer object deleted::"+customerId);
		return customer;
	}
	
	public void updateCustomer(Integer customerId) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Customer customer=session.get(Customer.class, customerId);
		customer.setCustomerAge(99);
		tx.commit();//checks if there is any difference between cached object and db object- if yes, it will call update
		System.out.println("customer object updated for ID::"+customerId);
	}
	
	@SuppressWarnings("deprecation")
	public void updateCustomer(Customer customer) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(customer);
		tx.commit();
		System.out.println("Customer object updated successfully....");
	}
	
	
	public void mergeCustomer(Integer customerId) {
		Session session1=sessionFactory.openSession();
		Customer customer1=session1.get(Customer.class, customerId);//1
		session1.close();//customer object is not associated with session(detached state)
		customer1.setCustomerAddress("DELHI");//updating detached object 
		
		Session session2=sessionFactory.openSession();
		//load same object again from DB.
		Customer customer2=session2.get(Customer.class, customerId);//1
		Transaction tx=session2.beginTransaction();
		//customer1 changes will merge into customer2
		session2.merge(customer1);
		
		tx.commit();//checks if there is any difference between cached object and db object- if yes, it will call update
		System.out.println("customer object merged for ID::"+customerId);
	}
	
	

}
