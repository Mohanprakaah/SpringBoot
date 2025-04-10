package com.edu.dto;

import com.edu.dao.Course;

public class StudentDto {
	private String studentName;
	private String studentEmailId;
	private String courseName;
	
	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentDto(String studentName, String studentEmailId, String courseName) {
		super();
		this.studentName = studentName;
		this.studentEmailId = studentEmailId;
		this.courseName = courseName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentEmailId() {
		return studentEmailId;
	}

	public void setStudentEmailId(String studentEmailId) {
		this.studentEmailId = studentEmailId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@Override
	public String toString() {
		return "StudentDto [studentName=" + studentName + ", studentEmailId=" + studentEmailId + ", courseName="
				+ courseName + "]";
	}
}
	
	
