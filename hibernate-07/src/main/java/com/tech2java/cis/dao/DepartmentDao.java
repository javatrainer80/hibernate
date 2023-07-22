package com.tech2java.cis.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tech2java.cis.entity.Department;
import com.tech2java.cis.util.HibernateUtil;

public class DepartmentDao {
	
	static SessionFactory sessionFactory=null;
	
	static {
		sessionFactory=HibernateUtil.getSessionFactory();
	}
	
	public void persistDepartment(Department department) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.persist(department);//persist department with employees as cascade=ALL
		tx.commit();
		
		System.out.println("Department with Employess saved successfully....");
	}
	
	
	public Department getDepartmentWithEmployees(Integer deptIdId) {
		Session session=sessionFactory.openSession();
		System.out.println("Before calling get method.");
		Department employee=session.get(Department.class, deptIdId);
		System.out.println("After calling get method.");
		//System.out.println("Employee object::"+employee);
		return employee;
	}
	
	
	
	public void removeDepartment(Integer deptIdId) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Department employee=session.get(Department.class, deptIdId);
		session.remove(employee);
		tx.commit();
		System.out.println("Department object deleted::"+deptIdId);
		
	}
	
	
	
	
	

}
