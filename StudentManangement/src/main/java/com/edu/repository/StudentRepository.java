package com.edu.repository;





import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edu.dao.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {



	public Student findByStudentEmailId(String studentEmailId);


	public List<Student> findByStudentName(String studentName);

	@Query(value= "select * from student where student_emailid=? ", nativeQuery = true)
	public Student getStudentByEmail(String studentEmailId);




}