package com.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edu.dao.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{






public Course findByCourseName(String courseName);

public List<Course> findByCourseFees(float courseFees);


@Query(value="select * from course where course_name=?", nativeQuery = true)
public Course findCourseByNameQueryMethod(String courseName);

@Query(value="select * from course where course_fees=?", nativeQuery = true)
public List<Course> getCourseByFeesQueryMethod(float courseFees);

}
