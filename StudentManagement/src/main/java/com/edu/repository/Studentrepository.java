package com.edu.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.dao.Student;

@Repository
public interface Studentrepository extends JpaRepository<Student, Integer> {

	
	
public 	Student findByStudentEmailId(String studentEmailId);

public List<Student> findByStudentName(String studentName);

	 

	

	

	

	

	
	
	
	
	
	

}