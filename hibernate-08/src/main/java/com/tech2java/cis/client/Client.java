package com.tech2java.cis.client;

import com.tech2java.cis.dao.DepartmentDao;
import com.tech2java.cis.entity.Department;
import com.tech2java.cis.entity.Employee;

public class Client {

	public static void main(String[] args) {

		try {
			
			DepartmentDao departmentDao=new DepartmentDao();
			/**OneToMany Example***/
			/*
			
			
			Employee e1=new Employee();
			e1.setEmpName("Naveen");
			Employee e2=new Employee();
			e2.setEmpName("Ramesh");
			Set<Employee> empSet=new HashSet<>();
			empSet.add(e1);
			empSet.add(e2);
			
			
			Department department=new Department();
			department.setDeptName("Sales");
			department.setEmployees(empSet);
			
			departmentDao.persistDepartment(department);
			
			//Department department2=departmentDao.getDepartmentWithEmployees(1);
			//System.out.println("DEPT =>"+department2.getDeptName());
			//System.out.println("EMPLOYEES =>"+department2.getEmployees().size());
			
			
			//For DELETE use OneToMany
			
			*/
			
			/**ManytoOne Example***/
			
			Department department=new Department();
			department.setDeptName("Service");
			
			Employee e1=new Employee();
			e1.setEmpName("Naveen");
			e1.setDepartment(department);
			
			Employee e2=new Employee();
			e2.setEmpName("Ramesh");
			e2.setDepartment(department);
			
			
			//departmentDao.persistEmployeeWithDepartment(e1,e2);
			Employee employee=departmentDao.getEmployeeWithDept(4);
			System.out.println("EMPLOYEE=>"+employee);
			
			System.out.println("DEPARTMENT=>"+employee.getDepartment());
			
			
		} catch (Exception ex) {
			System.err.println("Exception occured...." + ex.toString());
		}

	}

}
