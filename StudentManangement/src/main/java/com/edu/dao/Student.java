package com.edu.dao;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;
	
	@NotBlank(message="Student Name Cannot be null")
	@Column(name = "student_name", length = 50, nullable = false)
	private String studentName;

	@Column(name = "student_dob")
	@Past(message="Date of Birth Should be past date")
	private Date studentDob;

	
	@Column(name = "student_emailid", length = 50, nullable = false, unique = true)
	@NotBlank(message="Email should not null or Blank")
	@Email
	@Pattern(regexp = "[a-zA-Z0-9._%+-]+@[A-Za-z0-9.-]+\\.[a-z]{2,3}", message = "Invalid email address")
	private String studentEmailId;

	
	@Column(name="student_age")
	@Min(value=18, message = "Min age is 18") 
	@Max(value=30, message = "max age is 30")
	private int studentAge;


	@Column(name="student_phone", length = 10,nullable = false, unique = true)
	@NotBlank(message="Phone should not null or Blank")
	@Pattern(regexp = "^[6-9]\\d{0,9}$")
	private String studentPhone;
	
	@JsonIgnore
	@ManyToOne
	@JoinTable(name = "course_id")
	private Course course;
	

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	public String getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}

	public Student(Integer studentId, @NotBlank(message = "Student Name Cannot be null") String studentName,
			@Past(message = "Date of Birth Should be past date") Date studentDob,
			@NotBlank(message = "Email should not null or Blank") @Pattern(regexp = "[a-zA-Z0-9._%+-]+@[A-Za-z0-9.-]+\\.[a-z]{2,3}", message = "Invalid email address") String studentEmailId,
			@Min(value = 18, message = "Min age is 18") @Max(value = 30, message = "max age is 30") int studentAge,
			@NotBlank(message = "Phone should not null or Blank") @Pattern(regexp = "^[6-9]\\d{0,9}$") String studentPhone) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentDob = studentDob;
		this.studentEmailId = studentEmailId;
		this.studentAge = studentAge;
		this.studentPhone = studentPhone;
	}

	



	public Student(Integer studentId, String studentName, Date studentDob, String studentEmailId) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentDob = studentDob;
		this.studentEmailId = studentEmailId;
	}

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

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentDob=" + studentDob
				+ ", studentEmailId=" + studentEmailId + ", studentAge=" + studentAge + ", studentPhone=" + studentPhone
				+ "]";
	}

	public void save(Student existingStudent) {
		// TODO Auto-generated method stub
		
	}


}
