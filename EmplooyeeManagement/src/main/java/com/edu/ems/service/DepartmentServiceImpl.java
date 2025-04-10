package com.edu.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.ems.dao.Department;
import com.edu.ems.dao.Employee;
import com.edu.ems.repository.DepartmentRepository;
import com.edu.ems.repository.EmployeeRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentRepository.save(department);
	}




	@Override
	public List<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}


	@Override
	public Department getDepartmentById(Integer departmentId) {
	
		return departmentRepository.findById(departmentId).get();
	}




	@Override
	public Department updateDepartmentToEmployee(Integer departmentId, Integer employeeId) {
		
		Department t = departmentRepository.findById(departmentId).get();
		Employee e = employeeRepository.findById(employeeId).get();
		
		e.setDepartment(t);
		employeeRepository.save(e);
		
		return t;
	}



	

}
