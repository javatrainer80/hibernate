package com.tech2java.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 * Table: customer
	Columns:
	CUSTOMER_ID int PK 
	CUSTOMER_NAME varchar(45) 
	CUSTOMER_AGE int 
	CUSTOMER_ADDRESS varchar(200)
 *
 */
@Entity
@Table(name = "customer")
public class Customer implements Serializable{

	
	private static final long serialVersionUID = -4450783499976750528L;

	@Id
	@Column(name = "CUSTOMER_ID")
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
	
	
}
