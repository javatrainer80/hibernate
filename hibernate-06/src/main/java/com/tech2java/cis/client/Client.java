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
			
			employeeDao.persistEmployee(employee);
			
		} catch (Exception ex) {
			System.err.println("Exception occured...." + ex.toString());
		}

	}

}
