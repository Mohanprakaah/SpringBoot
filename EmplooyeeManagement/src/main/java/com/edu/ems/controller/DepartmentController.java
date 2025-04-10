package com.edu.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.ems.dao.Department;
import com.edu.ems.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	//http://localhost:8080/saveDepartment
	@PostMapping("/saveDepartment")
	public Department saveDepartment(@RequestBody Department department){
		 return departmentService.saveDepartment(department);
	}
	
	//http://localhost:8080/getAllDepartment
	@GetMapping("/getAllDepartment")
	public List<Department> getAllDepartment(){
		return departmentService.getAllDepartment();
		
		
	}
	
	
	//http://localhost:8080/getDepartmentById/2
	@GetMapping("/getDepartmentById/{departmentid}")
	public Department getDepartmentById(@PathVariable("departmentid") Integer departmentId) {
		return departmentService.getDepartmentById(departmentId);
		
	}
	
	
	// http://localhost:8080/updateDepartmentToEmployee/2/1
	@PutMapping("/updateDepartmentToEmployee/{depid}/{empid}")
	public Department updateDepartmentToEmployee(@PathVariable("depid") Integer departmentId , @PathVariable("empid") Integer employeeId) {
		return departmentService.updateDepartmentToEmployee(departmentId,employeeId);
	}
	

}
