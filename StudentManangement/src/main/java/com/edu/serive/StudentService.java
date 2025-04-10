package com.edu.serive;

import java.util.List;

import com.edu.dao.Student;
import com.edu.dto.StudentDto;
import com.edu.error.GlobalException;

public interface StudentService {

	public Student saveStudent(Student student);


	public List<Student> getAllStudent();


	public Student getStudentById(Integer studentId) throws GlobalException;


	public String deleteByStudentId(Integer studentId) throws GlobalException;


	public Student updateStudentById(Integer studentId, Student student) throws GlobalException;


	public Student findByStudentEmailId(String studentEmailId) throws GlobalException;


	public List<Student> findByStudentName(String studentName);


	public Student getStudentByEmail(String studentEmailId);


	public StudentDto getStudentDetailsDto(Integer studentId);


	public List<Student> deleteStudent(Integer studentId);
	
	public Student findByStudentEmailOrPhone(String email, Long phone);









	


	








	
	

	

}
