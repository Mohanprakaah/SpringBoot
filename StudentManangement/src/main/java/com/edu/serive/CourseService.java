package com.edu.serive;

import java.util.List;

import com.edu.dao.Course;

import com.edu.error.GlobalException;

public interface CourseService {

public Course saveCourse(Course course);

public List<Course> getAllCourses();

public Course getCourseById(Integer courseId) throws GlobalException;

public String deleteCourseById(Integer courseId) throws GlobalException;

public Course updateCourseById(Integer courseId, Course course) throws GlobalException;

public Course getCourseByName(String courseName) throws GlobalException;

public Course getCourseByNameQueryMethod(String courseName);

public List<Course> getCourseByfeesQueryMethod(Float courseFees);

public Course updateCourseIdToStudent(Integer courseId, Integer studentId);


}
