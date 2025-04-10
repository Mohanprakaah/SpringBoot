package com.edu.dao;




import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;




@Entity
public class Employee {
	
	@Id
	@Column(name="employee_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer employeeId;
	
	@NotBlank(message= "Employee Name cannot be Null")
	@Column(name="employee_name", length = 50, nullable = false)
	private String employeeName;
	

	@Column(name="employee_age", length = 50, nullable = false)
	private int employeeAge;
	
	@Min(value=2000, message="Minimum value should be 2000")
	@Max(value=60000, message = "Maximum fees is 60000")
	@Column(name = "employee_salary", length = 50, nullable = false)
	private float employeeSalary;
	

	@Column(name = "employee_joindate",nullable = false)
	private Date employeeJoinDate;
	
	@NotBlank(message= "Employee Email id cannot be Null")
	@Column(name = "employee_emailid", length = 50, nullable = false, unique = true)
	private String employeeEmailId;
	
	

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer employeeId, String employeeName, int employeeAge, float employeeSalary,
			Date employeeJoinDate, String employeeEmailId, String employeePhoneNo) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeAge = employeeAge;
		this.employeeSalary = employeeSalary;
		this.employeeJoinDate = employeeJoinDate;
		this.employeeEmailId = employeeEmailId;
		
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmployeeAge() {
		return employeeAge;
	}

	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}

	public float getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(float employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public Date getEmployeeJoinDate() {
		return employeeJoinDate;
	}

	public void setEmployeeJoinDate(Date employeeJoinDate) {
		this.employeeJoinDate = employeeJoinDate;
	}

	public String getEmployeeEmailId() {
		return employeeEmailId;
	}

	public void setEmployeeEmailId(String employeeEmailId) {
		this.employeeEmailId = employeeEmailId;
	}

	

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeAge=" + employeeAge
				+ ", employeeSalary=" + employeeSalary + ", employeeJoinDate=" + employeeJoinDate + ", employeeEmailId="
				+ employeeEmailId + "  ]";
	}
	
	
	

}