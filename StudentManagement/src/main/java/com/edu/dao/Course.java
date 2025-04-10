package com.edu.dao;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.web.bind.annotation.CrossOrigin;


@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="course_id")
private Integer courseId;
	
	@Column(name="course_name", length = 30, nullable = false, unique = true)
@NotBlank(message="Course Name should not be blank")
	
	
	
	private String courseName;

	@Min(value=2000, message="Minimum value should be 2000")
	@Max(value=50000, message = "Maximum fees is 50000")
	private float courseFees;
@OneToMany(mappedBy="course")
 private List<Student> student;
public Course() {
	super();
	// TODO Auto-generated constructor stub
}


public Course(String courseName, float courseFees) {
	super();
	this.courseName = courseName;
	this.courseFees = courseFees;
}


public Integer getCourseId() {
	return courseId;
}


public void setCourseId(Integer courseId) {
	this.courseId = courseId;
}


public String getCourseName() {
	return courseName;
}


public void setCourseName(String courseName) {
	this.courseName = courseName;
}


public float getCourseFees() {
	return courseFees;
}


public void setCourseFees(float courseFees) {
	this.courseFees = courseFees;
}


public List<Student> getStudent() {
	return student;
}


public void setStudent(List<Student> student) {
	this.student = student;
}


@Override
public String toString() {
	return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseFees=" + courseFees + "]";
}



//generate construvtor from super class
//generate constructor using fields
//generate setter and getter method
//generate toString



}
