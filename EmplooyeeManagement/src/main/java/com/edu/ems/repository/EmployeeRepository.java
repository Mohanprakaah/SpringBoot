package com.edu.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.ems.dao.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	public Employee findByEmployeeEmailIdOrEmployeePhoneNo(String employeeEmailId, String employeePhoneNo);
	
	

}
