package com.edu.serive;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.Course;
import com.edu.dao.Student;
import com.edu.error.GlobalException;
import com.edu.repository.CourseRepository;
import com.edu.repository.Studentrepository;

@Service
public class CourseServiceImpl implements CourseService{
//inject the object repository layer
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private Studentrepository studentrepository;
	
	@Override
	public Course saveCourse(Course course) {
		// TODO Auto-generated method stub
		return courseRepository.save(course);
	}

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return courseRepository.findAll();
	}

	//@Override
	public Course getCourseById(Integer courseId) throws GlobalException {
		Optional<Course> cobj1= courseRepository.findById(courseId);
		if (cobj1.isPresent()) 
			
			return courseRepository.findById(courseId).get();
		
		else
			throw new GlobalException("course with id= "+courseId+"not found");
	}

	@Override
	public String deleteCourseById(Integer courseId) {
		courseRepository.deleteById(courseId);
		return "Course with id="+courseId+" is deleted";
				
	}
	@Override
	public Course getCourseByNameQueryMethod(String courseName) {
		// TODO Auto-generated method stub
		return courseRepository.findCourseByNameQueryMethod(courseName);
	}

	@Override
	public Course updateCourseById(Integer courseId, Course course) {
		
			
			//get the course by id 
			Course existingCourse = courseRepository.findById(courseId).get();
			
			if(existingCourse != null) {
				existingCourse.setCourseName(course.getCourseName());
				existingCourse.setCourseFees(course.getCourseFees());
				courseRepository.save(existingCourse);
				
			}
			return existingCourse;
		}
	@Override
	public Course getCourseById(String courseName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course getCourseByName(String courseName) {
		// TODO Auto-generated method stub
		return courseRepository.findByCourseName(courseName);
	}

	@Override
	public List<Course> getCourseByFees(float courseFees) {
		// TODO Auto-generated method stub
		return courseRepository.findByCourseFees(courseFees);
	}

	@Override
	public List<Course> getCourseByFeesQueryMethod(float courseFees) {
		// TODO Auto-generated method stub
		return courseRepository.getCourseByFeesQueryMethod(courseFees);
	}

	@Override
	public Course updateCourseIdToStudent(Integer courseId, Integer studentId) {
		Course c=courseRepository.findById(courseId).get();
		Student s=studentrepository.findById(studentId).get();
		
		
		s.setCourse(c);
		studentrepository.save(s);
		
		return c ;
	}

	
	
	}


