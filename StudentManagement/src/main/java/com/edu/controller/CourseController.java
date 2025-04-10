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
import com.edu.repository.CourseRepository;
import com.edu.serive.CourseService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	private CourseRepository courseRepository;
	
	/*@PostMapping ->insert record
	 * @GetMapping->select
	 * @DeleteMapping->Delete
	 * @PutMapping->update
	 */
	//  http://localhost:9090/saveCourse
	
	@PostMapping("/saveCourse")
	public ResponseEntity<Course> saveCourse(@Valid @RequestBody Course course) {
		
		
		Course cobj= courseRepository.findByCourseName(course.getCourseName());
		
		System.out.println(cobj);
		if (cobj!=null) {
			System.out.println("Course is"+course.getCourseName()+"already exist");
		return ResponseEntity.status(HttpStatus.CONFLICT).body(cobj);
		
		}
		
		else {
			
		   Course   cobj1=courseService.saveCourse(course);
		return  ResponseEntity.status(HttpStatus.CREATED).body(cobj1);//courseService.saveCourse(course);
		
	}}
	
	// http://localhost:9090/getAllCourses
	
	@GetMapping("/getAllCourses")
	public List<Course> getAllCourses(){
		return courseService.getAllCourses();
		
	}
	
	/*// http://localhost:9090/getCourseById/1
	@GetMapping("/getCourseById/{cid}")
	public Course getCourseById(@PathVariable("cid") Integer courseId){
	//public Course getCourseById(@ Integer courseId){
		return courseService.getCourseById(courseId);
			
		}*/
	// http://localhost:9090/deleteCourseById/1
	@DeleteMapping("/deleteCourseById/{cid}")
	public String deleteCourseById(@PathVariable("cid") Integer courseId) {
		return courseService.deleteCourseById(courseId);
		
	}
	
	//getCourseByName
	// http://localhost:9090/getCourseByCourseName/1
	@GetMapping("/getCourseByCourseName/{cname}")
	public Course getCourseByName(@PathVariable("cname")String courseName) {
		return courseService.getCourseByName(courseName);
	}
	
	
	// http://localhost:9090/updateCourseById/2
		@PutMapping("/updateCourseById/{cid}")
		public Course updateCourseById(@PathVariable("cid") Integer courseId, @RequestBody Course course) {
			return courseService.updateCourseById(courseId,course);
		}
		// http://localhost:9090/getCourseByFees/2
	@GetMapping("/getCourseByFees/{cfees}")
		public List<Course> getCourseByFees(@PathVariable("cfees")float courseFees){
			return courseService.getCourseByFees(courseFees);
		}
	//using Querymethod
	// http://localhost:9090/getCourseByNameQueryMethod/2
	@GetMapping("/getCourseByNameQueryMethod/{cname}")
	public Course getCourseByNameQueryMethod(@PathVariable("cname") String courseName) {
		return courseService.getCourseByNameQueryMethod(courseName);
		
	}
	// http://localhost:9090/getCourseByFeesQueryMethod/2
	@GetMapping("/getCourseByFeesQueryMethod/{cfees}")
 public List <Course> getCourseByFeesQueryMethod(@PathVariable("cfees") float courseFees) {
	 return courseService.getCourseByFeesQueryMethod(courseFees);
	 
 }
	
	//update course id to student
	//http://localhost:9090/updateCourseIdToStudent/2
	@PutMapping("/updateCourseIdToStudent/{cid}/{sid}")
	public Course updateCourseIdToStudent(@PathVariable ("cid") Integer courseId, @PathVariable("sid") Integer studentId) {
		return courseService.updateCourseIdToStudent(courseId, studentId);
		
	}
}




