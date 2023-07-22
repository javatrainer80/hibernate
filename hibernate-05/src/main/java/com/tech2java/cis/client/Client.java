package com.tech2java.cis.client;

import com.tech2java.cis.dao.CustomerDao;
import com.tech2java.cis.entity.Customer;

public class Client {

	public static void main(String[] args) {

		try {
			CustomerDao customerDao = new CustomerDao();
			// Create Customer Object
			Customer customer = new Customer();
			customer.setCustomerName("Rahul");
			customer.setCustomerAge(1);
			customer.setCustomerAddress("SEC");

			customerDao.persistCustomer(customer);
			
			
		} catch (Exception ex) {
			System.err.println("Exception occured...." + ex.toString());
		}

	}

}
