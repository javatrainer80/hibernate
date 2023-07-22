package com.tech2java.cis.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tech2java.cis.entity.Department;
import com.tech2java.cis.entity.Employee;
import com.tech2java.cis.util.HibernateUtil;

public class DepartmentDao {
	
	static SessionFactory sessionFactory=null;
	
	static {
		sessionFactory=HibernateUtil.getSessionFactory();
	}
	
	public void persistEmployeeWithDepartment(Employee employee1,Employee employee2) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.persist(employee1);
		session.persist(employee2);
		tx.commit();
		
		System.out.println("Employee with Department saved successfully....");
	}
	
	
	public Employee getEmployeeWithDept(Integer empId) {
		Session session=sessionFactory.openSession();
		System.out.println("Before calling get method.");
		Employee employee=session.get(Employee.class, empId);
		System.out.println("After calling get method.");
		//System.out.println("Employee object::"+employee);
		return employee;
	}
	
	
	
	public void removeDepartment(Integer deptIdId) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Department dept=session.get(Department.class, deptIdId);
		session.remove(dept);
		tx.commit();
		System.out.println("Department object deleted::"+deptIdId);
		
	}
	
	
	
	
	

}
