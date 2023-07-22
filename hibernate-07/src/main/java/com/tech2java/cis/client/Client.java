package com.tech2java.cis.client;

import java.util.HashSet;
import java.util.Set;

import com.tech2java.cis.dao.DepartmentDao;
import com.tech2java.cis.entity.Department;
import com.tech2java.cis.entity.Employee;

public class Client {

	public static void main(String[] args) {

		try {
			
			DepartmentDao departmentDao=new DepartmentDao();
			
			Employee e1=new Employee();
			e1.setEmpName("Rahul");
			Employee e2=new Employee();
			e2.setEmpName("Uday");
			Set<Employee> empSet=new HashSet<>();
			empSet.add(e1);
			empSet.add(e2);
			
			
			Department department=new Department();
			department.setDeptName("IT");
			department.setEmployees(empSet);
			
			//departmentDao.persistDepartment(department);
			
			Department department2=departmentDao.getDepartmentWithEmployees(1);
			System.out.println("DEPT =>"+department2.getDeptName());
			System.out.println("EMPLOYEES =>"+department2.getEmployees().size());
			
		} catch (Exception ex) {
			System.err.println("Exception occured...." + ex.toString());
		}

	}

}
