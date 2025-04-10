package com.edu.serivce;



import java.util.List;

import com.edu.dao.Employee;
import com.edu.dto.EmployeeDto;



public interface EmployeeService {

	public Employee saveEmployee(Employee employee);

	public List<Employee> getAllEmployee();

	public Employee getEmployeeById(Integer employeeId);

	public EmployeeDto getEmployeeDetailId(Integer employeeId);

}



	


