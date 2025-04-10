package com.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.dao.DataIntegrityViolationException;
import com.edu.dao.Student;
import com.edu.dto.StudentDto;
import com.edu.error.GlobalException;
import com.edu.serive.StudentService;

@CrossOrigin(origins = "http://localhost:4200") // connect with Angular
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    

    @PostMapping("/saveStudent")
    public ResponseEntity<?> saveStudent(@RequestBody Student student) {
        try {
            Student savedStudent = studentService.saveStudent(student);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("Email or phone number already exists!");
        }
    }


    // GET: http://localhost:8080/getAllStudent
    @GetMapping("/getAllStudent")
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    // GET: http://localhost:8080/getByStudentId/{sid}
    @GetMapping("/getByStudentId/{sid}")
    public Student getByStudentId(@PathVariable("sid") Integer studentId) throws GlobalException {
        return studentService.getStudentById(studentId);
    }

    // DELETE: http://localhost:8080/deleteByStudentId/{sid}
    @DeleteMapping("/deleteByStudentId/{sid}")
    public String deleteByStudentId(@PathVariable("sid") Integer studentId) throws GlobalException {
        return studentService.deleteByStudentId(studentId);
    }

    // DELETE: http://localhost:8080/deleteStudent/{sid}
    @DeleteMapping("/deleteStudent/{sid}")
    public List<Student> deleteStudent(@PathVariable("sid") Integer studentId) {
        return studentService.deleteStudent(studentId);
    }

    // PUT: http://localhost:8080/updateStudentById/{sid}
    @PutMapping("/updateStudentById/{sid}")
    public Student updateStudentById(@PathVariable("sid") Integer studentId, @RequestBody Student student)
            throws GlobalException {
        return studentService.updateStudentById(studentId, student);
    }

    // GET: http://localhost:8080/findByStudentEmailId/{email}
    @GetMapping("/findByStudentEmailId/{email}")
    public Student findByStudentEmailId(@PathVariable("email") String studentEmailId) throws GlobalException {
        return studentService.findByStudentEmailId(studentEmailId);
    }

    // GET: http://localhost:8080/findByStudentName/{sname}
    @GetMapping("/findByStudentName/{sname}")
    public List<Student> findByStudentName(@PathVariable("sname") String studentName) {
        return studentService.findByStudentName(studentName);
    }

    // GET: http://localhost:8080/getStudentByEmail/{email}
    @GetMapping("/getStudentByEmail/{email}")
    public Student getStudentByEmail(@PathVariable("email") String studentEmailId) {
        return studentService.getStudentByEmail(studentEmailId);
    }

    // GET: http://localhost:8080/getStudentDetailsDto/{sid}
    @GetMapping("/getStudentDetailsDto/{sid}")
    public StudentDto getStudentDetailsDto(@PathVariable("sid") Integer studentId) {
        return studentService.getStudentDetailsDto(studentId);
    }
}
