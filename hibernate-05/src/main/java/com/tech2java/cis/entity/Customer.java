package com.tech2java.cis.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 CREATE TABLE `customer` (
  `CUSTOMER_ID` int NOT NULL AUTO_INCREMENT,
  `CUSTOMER_ADDRESS` varchar(255) DEFAULT NULL,
  `CUSTOMER_AGE` int DEFAULT NULL,
  `CUSTOMER_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CUSTOMER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

 *
 */
@Entity
@Table(name = "customer")
public class Customer implements Serializable{

	
	private static final long serialVersionUID = -4450783499976750528L;

	
	@Id
	@Column(name = "CUSTOMER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	
	@Column(name = "CUSTOMER_NAME")
	private String customerName;
	
	@Column(name = "CUSTOMER_AGE")
	private Integer customerAge;
	
	@Column(name = "CUSTOMER_ADDRESS")
	private String customerAddress;
	
	//Getters & Setters
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Integer getCustomerAge() {
		return customerAge;
	}
	public void setCustomerAge(Integer customerAge) {
		this.customerAge = customerAge;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerAge=" + customerAge
				+ ", customerAddress=" + customerAddress + "]";
	}
	
	
	
}
