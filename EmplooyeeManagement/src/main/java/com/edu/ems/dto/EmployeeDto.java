package com.edu.ems.dto;

public class EmployeeDto {
	
	private String employeeName;
	private String employeeEmailId;
	private String departmentName;
	
	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeDto(String employeeName, String employeeEmailId, String departmentName) {
		super();
		this.employeeName = employeeName;
		this.employeeEmailId = employeeEmailId;
		this.departmentName = departmentName;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeEmailId() {
		return employeeEmailId;
	}
	public void setEmployeeEmailId(String employeeEmailId) {
		this.employeeEmailId = employeeEmailId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	@Override
	public String toString() {
		return "EmployeeDto [employeeName=" + employeeName + ", employeeEmailId=" + employeeEmailId
				+ ", departmentName=" + departmentName + "]";
	}
	
	
	
	

}
