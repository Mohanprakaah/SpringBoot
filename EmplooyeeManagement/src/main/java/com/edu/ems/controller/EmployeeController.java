package com.edu.ems.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.edu.ems.dao.Employee;
import com.edu.ems.dto.EmployeeDto;
import com.edu.ems.repository.EmployeeRepository;
import com.edu.ems.service.EmployeeService;



@RestController
public class EmployeeController {

	
	@Autowired
	private EmployeeService employeeService;

	@Autowired
    private EmployeeRepository employeeRepository;
	
	// http://localhost:8080/saveEmployee
	@PostMapping("/saveEmployee")
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee){
		 Employee e1 = employeeRepository.findByEmployeeEmailIdOrEmployeePhoneNo(employee.getEmployeeEmailId(),employee.getEmployeePhoneNo());
		 if (e1!=null) {
			 return ResponseEntity.status(HttpStatus.CONFLICT).body(e1);
		 }
		 else {
			 Employee e2 = employeeService.saveEmployee(employee);
			 return ResponseEntity.status(HttpStatus.CREATED).body(e2);
		 }
		  
	}
	
//	{
//        "employeeName" : "Deepak",
//		"employeeAge" : 20,
//		"employeeSalary" : 200000,
//		"employeeJoinDate" : "2020-12-04",
//		"employeeEmailId" :"deepak@gmail.com"
//		"employeePhoneNo" : 9710286333
//    }
	
	// http://localhost:8080/getAllEmployee
	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployee();
	}
	
	// http://localhost:8080/getEmployeeDetails/2
	@GetMapping("/getEmployeeDetails/{eid}")
	public EmployeeDto getEmployeeDetails(@PathVariable("eid") Integer employeeId){
		return employeeService.getEmployeeDetails(employeeId);
	}
	
	
	
	

}
