package com.edu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.dao.Course;
import com.edu.dao.Student;
import com.edu.dto.StudentDto;
import com.edu.error.GlobalException;
import com.edu.error.RestResponseEntityExceptionHandler;
import com.edu.repository.Studentrepository;
import com.edu.serive.StudentService;

@CrossOrigin( origins = "http://localhost:4200" )
@RestController
public class StudentController {

    private final RestResponseEntityExceptionHandler restResponseEntityExceptionHandler;
     
	@Autowired
	private StudentService studentService;
	@Autowired
	 private Studentrepository studentrepository;


    StudentController(RestResponseEntityExceptionHandler restResponseEntityExceptionHandler) {
        this.restResponseEntityExceptionHandler = restResponseEntityExceptionHandler;
    }
	
	
	@PostMapping("/saveStudent")
	public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student) {
    Student sobj= studentService.findByStudentEmailId(student.getStudentName());
		
		System.out.println(sobj);
		if (sobj!=null) {
			System.out.println("Student is="+student.getStudentEmailId()+"already exist");
		return ResponseEntity.status(HttpStatus.CONFLICT).body(sobj);
		
	}
		else {
			Student sobj1= studentService.saveStudent(student);
					return ResponseEntity.status(HttpStatus.CREATED).body(sobj);
		}
			
		}

	//http://localhost:9090/getAllStudents
@GetMapping("/getAllStudents")
	public List<Student> getAllStudents(){
	return studentService.getAllStudent();
	
}
//http://localhost:9090/getStudentById/5
@GetMapping("/getStudentById/{sid}")
public Student getStudentById(@PathVariable ("sid") Integer studentId ) throws GlobalException {
	return studentService.getStudentById(studentId);
}
//http://localhost:9090/findByStudentName/

		@GetMapping("/findByStudentName/{sname}")
		public List<Student> findByStudentName(@PathVariable("sname") String studentName) {
		    return studentService.findByStudentName(studentName);
		}

//http://localhost:9090/updateStudentById/5
@PostMapping("/updateStudentById/{sid}")
public Student  updateStudentById(@PathVariable ("sid") Integer studentId, @RequestBody Student student) {
	return studentService.updateStudentById(studentId,student);
}
//http://localhost:9090/deleteStudentById/5
@DeleteMapping("/deleteStudentById/{sid}")
public String deleteStudentById(@PathVariable ("sid") Integer studentId) {
	return studentService.deleteStudentById(studentId);
	
}
//http://localhost:9090/findByStudentEmailId/5
@GetMapping("/findBystudentEmailId/{email}")
public Student findByStudentEmailId(@PathVariable("email") String studentEmailId) {
	return studentService.findByStudentEmailId();
}

//http://localhost:9090/getStudentDetailDto/5
//get Student details using Dto 
@GetMapping("/getStudentDetailDto/{sid}")
	public StudentDto getStudentDetailDto(@PathVariable("sid") Integer studentId) {
		return studentService.getStudentDetailDto(studentId);
		
	}

}

