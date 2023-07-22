package com.tech2java.cis.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "DEPARTMENT")
public class Department implements Serializable {

	private static final long serialVersionUID = -4450783499976750528L;

	@Id
	@Column(name = "DEPT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer deptId;

	@Column(name = "EMP_NAME")
	private String deptName;
	
	@OneToMany(targetEntity = Employee.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "dept_id",referencedColumnName = "dept_id")
	private Set<Employee> employees;

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", employees=" + employees + "]";
	}
	
	
	
}
