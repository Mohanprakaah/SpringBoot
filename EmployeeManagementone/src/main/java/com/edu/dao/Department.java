package com.edu.dao;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="department_id")
	private Integer departmentid;
	@Column(name="department_name",length=50,nullable = false,unique = true)
	private String departmentName;
	@Override
	public String toString() {
		return "Department [departmentid=" + departmentid + ", departmentName=" + departmentName + "]";
	}
	public Integer getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(Integer departmentid) {
		this.departmentid = departmentid;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Department(String departmentName) {
		super();
		this.departmentName = departmentName;
	}
	
	@OneToMany
	public List<Employee> employee;
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

}
