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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.dao.Course;
import com.edu.error.GlobalException;
import com.edu.repository.CourseRepository;
import com.edu.serive.CourseService;

@CrossOrigin(origins = "http://localhost:4200")//connect with ang
@RestController
public class CourseController {

    

	@Autowired
	private CourseService courseService;
	
	@Autowired
	private CourseRepository courseRepository;

	
	
	
	 /*@PostMapping ->insert record
	 * @GetMapping->select
	 * @DeleteMapping->Delete
	 * @PutMapping->update
	 */
	
	
	//  http://localhost:8080/saveCourse
	@PostMapping("/saveCourse")
	public ResponseEntity<Course> saveCourse(@Valid @RequestBody Course course) {
		//Check Unique Constrains
		
		Course cobj = courseRepository.findByCourseName(course.getCourseName());
		System.out.println(cobj);
		
		//return courseService.saveCourse(course);
		if(cobj!=null) {
			System.out.println("Course Name=" + course.getCourseName() + "is Already Exsists");
			return ResponseEntity.status(HttpStatus.CONFLICT).body(cobj);
		}
		else {
			Course cobj1 = courseService.saveCourse(course);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(cobj1);
		}
			
	}
	
	// http://localhost:8080/getAllCourses
	
	@GetMapping("/getAllCourses")
	public List<Course> getAllCourses(){
		return courseService.getAllCourses();
		
	}
	
	
	
	// http://localhost:8080/getCourseById/1
	@GetMapping("/getCourseById/{cid}")
	public Course getCourseById(@PathVariable("cid") Integer courseId) throws GlobalException{
	//public Course getCourseById(@ Integer courseId){
		return courseService.getCourseById(courseId);
			
	}
	
	// http://localhost:8080/deleteCourseById/1
	@DeleteMapping("/deleteCourseById/{cid}")
	public String deleteCourseById(@PathVariable("cid") Integer courseId) throws GlobalException {
		return courseService.deleteCourseById(courseId);
		
	}
	
	// http://localhost:8080/updateCourseById/2
	@PutMapping("/updateCourseById/{cid}")
	public Course updateCourseById(@PathVariable("cid") Integer courseId, @RequestBody Course course) throws GlobalException {
		return courseService.updateCourseById(courseId,course);
	}
	
	// http://localhost:8080/getCourseByName/Full Stack Java
	@GetMapping("/getCourseByName/{cname}")
	public Course getCourseByName(@PathVariable("cname") String courseName) throws GlobalException {
		return courseService.getCourseByName(courseName);
		
	}
	
	//using Query 
	// http://localhost:8080/getCourseByNameQueryMethod/Full Stack Java
	@GetMapping("/getCourseByNameQueryMethod/{cname}")
	public Course getCourseByNameQueryMethod(@PathVariable("cname") String courseName) {
		
		return courseService.getCourseByNameQueryMethod(courseName);
		
		
	}
	
		// http://localhost:8080/getCourseByfeesQueryMethod/100000.0
		@GetMapping("/getCourseByfeesQueryMethod/{cfees}")
		public List<Course> getCourseByfeesQueryMethod(@PathVariable("cfees") Float courseFees) {
			
			return courseService.getCourseByfeesQueryMethod(courseFees);
			
			
		}
		
		// http://localhost:8080/updateCourseIdToStudent/4/3
		@PutMapping("/updateCourseIdToStudent/{cid}/{sid}")
		public Course updateCourseIdToStudent(@PathVariable("cid") Integer courseId , @PathVariable("sid") Integer studentId){
		{
			
			return courseService.updateCourseIdToStudent(courseId, studentId);
		}
			
			
			
		}



	
		
	}

