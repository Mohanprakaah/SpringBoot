package com.edu.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.ems.dao.Department;
import com.edu.ems.dao.Employee;
import com.edu.ems.dto.EmployeeDto;
import com.edu.ems.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}


	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}


	@Override
	public EmployeeDto getStudentDetails(Integer employeeId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public EmployeeDto getEmployeeDetails(Integer employeeId) {
		Employee eob = employeeRepository.findById(employeeId).get();
		EmployeeDto edto = new EmployeeDto();
		edto.setEmployeeEmailId(eob.getEmployeeEmailId());
		edto.setEmployeeName(eob.getEmployeeName());
		
		Department d = eob.getDepartment();
		edto.setDepartmentName(d.getDepartmentName());
		
		return edto;
	}


	


}
