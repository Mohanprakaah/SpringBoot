package com.edu.serivce;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.Employee;
import com.edu.dto.EmployeeDto;
import com.edu.repository.EmployeeRepository;



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
	public Employee getEmployeeById(Integer employeeId) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(employeeId).get();
	}


	@Override
	public EmployeeDto getEmployeeDetailId(Integer employeeId) {
		Employee e=employeeRepository.findById(employeeId).get();
		EmployeeDto empd=new EmployeeDto();
		empd.setEmployeeName(e.getEmployeeName());
		empd.setEmployeeAge(e.getEmployeeAge());
		return empd;
	}


}















	


