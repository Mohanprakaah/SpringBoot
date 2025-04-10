package com.edu.ems.service;

import java.util.List;

import com.edu.ems.dao.Department;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> getAllDepartment();

	public Department getDepartmentById(Integer departmentId);

	public Department updateDepartmentToEmployee(Integer departmentId, Integer employeeId);
	
	

}
