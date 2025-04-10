package com.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PatchExchange;

import com.edu.dao.Employee;
import com.edu.dto.EmployeeDto;
import com.edu.serivce.EmployeeService;

import jakarta.validation.Valid;

;







@RestController
public class EmployeeController {

	
	@Autowired
	private EmployeeService employeeService;

   
	
	// http://localhost:8080/saveEmployee
	@PostMapping("/saveEmployee")
	public Employee saveEmployee(@Valid @RequestBody Employee employee){
		  return employeeService.saveEmployee(employee);
	}
	

	
	// http://localhost:8080/getAllEmployee
	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployee();
	}
	
	//http://localhost:9090/getEmployeeById/
@GetMapping("/ getEmployeeById/{eid}")
public Employee getEmployeeById(@PathVariable ("eid") Integer employeeId)   {
	return employeeService.getEmployeeById(employeeId);
}

//http://localhost:9090/getEmployeeDetailId/3
@GetMapping("/getEmployeeDetailId/{eid}")
 public EmployeeDto getEmployeeDetailId(@PathVariable ("eid")Integer employeeId) {
	return employeeService.getEmployeeDetailId(employeeId);
	 
 }
	
}


