package com.edu.serive;

import java.util.List;

import com.edu.dao.Student;
import com.edu.dto.StudentDto;
import com.edu.error.GlobalException;

public interface StudentService {

public 	Student saveStudent(Student student);

public List<Student> getAllStudent();

public Student getStudentById(Integer studentId) throws GlobalException;





public Student updateStudentById(Integer studentId, Student student);

public String deleteStudentById(Integer studentId);



public Student findByStudentEmailId();

 public Student findByStudentEmailId(String studentEmailId);

public List<Student> findByStudentName(String studentName);

public StudentDto getStudentDetailDto(Integer studentId);



}
