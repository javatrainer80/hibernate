package com.tech2java.cis.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PASSPORT")
public class Passport {
	
	@Column(name = "PID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	
	@Column(name="PASSPORT_NUMBER",nullable = false)
	private String passportNumber;
	
	//Add mapped by non-owning side of relationship so OneToOne relationship owned by Employee now
	//else duplicate data in both tables - employee_id will not be created in Passport table.
	@OneToOne(targetEntity = Employee.class,mappedBy = "passport", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "empid", referencedColumnName = "EMP_ID")
	private Employee employee;
	
	

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Passport [pid=" + pid + ", passportNumber=" + passportNumber + "]";
	}

}
