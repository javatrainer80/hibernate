package com.tech2java.cis.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tech2java.cis.entity.Employee;
import com.tech2java.cis.entity.Passport;
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
	
	
	public Employee getEmployeeWithPassport(Integer employeeId) {
		Session session=sessionFactory.openSession();
		System.out.println("Before calling get method.");
		Employee employee=session.get(Employee.class, employeeId);
		System.out.println("After calling get method.");
		//System.out.println("Employee object::"+employee);
		return employee;
	}
	
	public Passport getPassportWithemployee(Integer passportId) {
		Session session=sessionFactory.openSession();
		System.out.println("Before calling get method.");
		Passport passport=session.get(Passport.class, passportId);
		System.out.println("After calling get method.");
		//System.out.println("Employee object::"+employee);
		return passport;
	}
	
	public void removeEmployee(Integer employeeId) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Employee employee=session.get(Employee.class, employeeId);
		session.remove(employee);
		tx.commit();
		System.out.println("Employee object deleted::"+employeeId);
		
	}
	
	
	
	
	

}
