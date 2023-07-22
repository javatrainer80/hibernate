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

			// customerDao.saveCustomer(customer);
			//customerDao.persistCustomer(customer);
			//customerDao.loadCustomer(2);
			//customerDao.getCustomer(20);
			//customerDao.deleteCustomer(2);
			//customerDao.removeCustomer(4);
			//customerDao.updateCustomer(1);
			
			
			Customer updateCustomer = new Customer();
			updateCustomer.setCustomerId(1);//id should exist in DB else org.hibernate.TransientObjectException: The given object has a null identifier
			updateCustomer.setCustomerName("Rahul");
			updateCustomer.setCustomerAge(80);
			updateCustomer.setCustomerAddress("SEC");
			//customerDao.updateCustomer(updateCustomer);
			
			customerDao.mergeCustomer(1);

		} catch (Exception ex) {
			System.err.println("Exception occured...." + ex.toString());
		}

	}

}
