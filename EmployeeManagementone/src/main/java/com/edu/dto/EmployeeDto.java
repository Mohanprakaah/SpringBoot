package com.edu.dto;

public class EmployeeDto {
	private String employeeName;
	private int employeeAge;
	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeDto(String employeeName, int employeeAge) {
		super();
		this.employeeName = employeeName;
		this.employeeAge = employeeAge;
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
	public void setEmployeeAge(int i) {
		this.employeeAge = i;
	}
	@Override
	public String toString() {
		return "EmployeeDto [employeeName=" + employeeName + ", employeeAge=" + employeeAge + "]";
	}

}
