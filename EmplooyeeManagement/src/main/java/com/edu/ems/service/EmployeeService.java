package com.edu.ems.service;

import java.util.List;

import com.edu.ems.dao.Employee;
import com.edu.ems.dto.EmployeeDto;

public interface EmployeeService {

	public Employee saveEmployee(Employee employee);

	public List<Employee> getAllEmployee();

	public EmployeeDto getStudentDetails(Integer employeeId);

	public EmployeeDto getEmployeeDetails(Integer employeeId);

}
