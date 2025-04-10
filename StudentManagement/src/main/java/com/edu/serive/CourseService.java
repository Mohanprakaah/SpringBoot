package com.edu.serive;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.edu.dao.Course;

public interface CourseService {

public Course saveCourse(Course course);

public List<Course> getAllCourses();

public Course getCourseById(String courseName);

public String deleteCourseById(Integer courseId);

public Course getCourseByName(String courseName);


public Course updateCourseById(Integer courseId, Course course);

public List<Course> getCourseByFees(float courseFees);




public Course getCourseByNameQueryMethod(String courseName);

public List<Course> getCourseByFeesQueryMethod(float courseFees);

public Course updateCourseIdToStudent(Integer courseId, Integer studentId);

}
