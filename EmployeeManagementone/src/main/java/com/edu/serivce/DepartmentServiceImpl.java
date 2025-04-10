package com.edu.serivce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.Department;
import com.edu.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
//inject department repository
	
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	
	@Override
	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentRepository.save(department);
	}


	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll() ;
	}


	@Override
	public Department getDepartmentById(Integer departmentId) {
		
		return departmentRepository.findById(departmentId).get();
	}

}
