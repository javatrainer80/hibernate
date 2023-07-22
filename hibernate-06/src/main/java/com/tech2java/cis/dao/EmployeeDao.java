package com.tech2java.cis.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tech2java.cis.entity.Employee;
import com.tech2java.cis.util.HibernateUtil;

public class EmployeeDao {
	
	static SessionFactory sessionFactory=null;
	
	static {
		sessionFactory=HibernateUtil.getSessionFactory();
	}
	
	public void persistEmployee(Employee employee) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		//session.persist(employee.getPassport());//persist passport (or use cascade options)
		session.persist(employee);//persist employee
		tx.commit();
		
		System.out.println("Employee object saved successfully....");
	}
	
	
	public Employee getCustomer(Integer employeeId) {
		Session session=sessionFactory.openSession();
		System.out.println("Before calling load method.");
		Employee customer=session.get(Employee.class, employeeId);
		System.out.println("After calling load method.");
		System.out.println("Employee object::"+customer);
		return customer;
	}
	
	public Employee removeCustomer(Integer employeeId) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Employee customer=session.get(Employee.class, employeeId);
		session.remove(customer);
		tx.commit();
		System.out.println("Employee object deleted::"+employeeId);
		return customer;
	}
	
	
	
	
	

}
