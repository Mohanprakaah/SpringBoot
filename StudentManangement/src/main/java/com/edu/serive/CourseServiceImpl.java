package com.edu.serive;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.Course;
import com.edu.dao.Student;
import com.edu.error.GlobalException;
import com.edu.repository.CourseRepository;
import com.edu.repository.StudentRepository;

@Service
public class CourseServiceImpl implements CourseService{
//inject the object repository layer
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
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

	@Override
	public Course getCourseById(Integer courseId) throws GlobalException {
	    Optional<Course> cobj = courseRepository.findById(courseId);
	    if (cobj.isPresent()) {
	        return cobj.get(); // Get the course if present
	    } else {
	        throw new GlobalException("Course with id=" + courseId + " not found.");
	    }
	}

	@Override
	public String deleteCourseById(Integer courseId) throws GlobalException {
	    if (courseRepository.existsById(courseId)) {
	        courseRepository.deleteById(courseId);
	        return "Course with id=" + courseId + " is deleted.";
	    } else {
	        throw new GlobalException("Course with id=" + courseId + " not found, cannot delete.");
	    }
	}

	@Override
	public Course updateCourseById(Integer courseId, Course course) throws GlobalException {
	    Optional<Course> optionalCourse = courseRepository.findById(courseId);
	    if (optionalCourse.isPresent()) {
	        Course existingCourse = optionalCourse.get();
	        existingCourse.setCourseName(course.getCourseName());
	        existingCourse.setCourseFees(course.getCourseFees());
	        
	        // Save updated course
	        return courseRepository.save(existingCourse);
	    } else {
	        throw new GlobalException("Course with id=" + courseId + " not found, cannot update.");
	    }
	}


	@Override
	public Course getCourseByName(String courseName) throws GlobalException {
		
		Course c = courseRepository.findByCourseName(courseName);
		if(c!=null) {
			return courseRepository.findByCourseName(courseName);
		}
		else {
			throw new GlobalException("Course with name=" + courseName + " not found, cannot update.");
		}
		
	}

	@Override
	public Course getCourseByNameQueryMethod(String courseName) {
		
		return courseRepository.findByCourseName(courseName);
	}

	@Override
	public List<Course> getCourseByfeesQueryMethod(Float courseFees) {
		
		return courseRepository.findCourseByfeeseNative(courseFees);
		
	}

	@Override
	public Course updateCourseIdToStudent(Integer courseId, Integer studentId) {
		Course c = courseRepository.findById(courseId).get();
		Student s = studentRepository.findById(studentId).get();
		
		s.setCourse(c);
		studentRepository.save(s);
		return c;
	}

	

	

}
