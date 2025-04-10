package com.edu.dao;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer studentId;
@NotBlank(message="enter your name to process")	
private String studentName;
private Date studentDob;


private String studentEmailId;

@JsonIgnore
@ManyToOne
@JoinColumn(name="course_id")
private Course course;

public Student() {
	super();
	// TODO Auto-generated constructor stub
}
public Student(String studentName, Date studentDob, String studentEmailId) {
	super();
	this.studentName = studentName;
	this.studentDob = studentDob;
	this.studentEmailId = studentEmailId;
}
public Integer getStudentId() {
	return studentId;
}
public void setStudentId(Integer studentId) {
	this.studentId = studentId;
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public Date getStudentDob() {
	return studentDob;
}
public void setStudentDob(Date studentDob) {
	this.studentDob = studentDob;
}
public String getStudentEmailId() {
	return studentEmailId;
}
public void setStudentEmailId(String studentEmailId) {
	this.studentEmailId = studentEmailId;
}

public Course getCourse() {
	return course;
}
public void setCourse(Course course) {
	this.course = course;
}
@Override
public String toString() {
	return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentDob=" + studentDob
			+ ", studentEmailId=" + studentEmailId + "]";
}




}
