package com.tech2java.cis.client;

import com.tech2java.cis.dao.EmployeeDao;
import com.tech2java.cis.entity.Employee;
import com.tech2java.cis.entity.Passport;

public class Client {

	public static void main(String[] args) {

		try {
			
			EmployeeDao employeeDao=new EmployeeDao();
			
			Passport passport=new Passport();
			passport.setPassportNumber("K09333");
			Employee employee=new Employee();
			employee.setEmpName("Naveen");
			employee.setPassport(passport);
			//Persist
			//employeeDao.persistEmployee(employee);
			
			//GetEmployee Unidirectional
			/*
			Employee employee2=employeeDao.getEmployeeWithPassport(1);
			
			System.out.println("Employee::"+employee2);
			System.out.println("Executing query related to passport.");
			System.out.println("Passport::"+employee2.getPassport());
			*/
			//Bidirectional testing
			Passport passport2=employeeDao.getPassportWithemployee(1);
			System.out.println("PASSPORT=>"+passport2);
			System.out.println("Employee=>"+passport2.getEmployee());
			
		} catch (Exception ex) {
			System.err.println("Exception occured...." + ex.toString());
		}

	}

}
