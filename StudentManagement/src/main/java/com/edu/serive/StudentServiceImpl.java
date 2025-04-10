package com.edu.serive;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.Course;
import com.edu.dao.Student;
import com.edu.dto.StudentDto;
import com.edu.error.GlobalException;
import com.edu.repository.Studentrepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private Studentrepository studentrepository;
	
	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentrepository.save(student);
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentrepository.findAll();
	}

	@Override
	public Student getStudentById(Integer studentId) throws GlobalException {
		Optional<Student> sobj= studentrepository.findById(studentId);
		if(sobj.isPresent())
		 return studentrepository.findById(studentId).get();
		
		else
			throw new GlobalException("student with id= "+studentId+"not found");
	}

	

	@Override
	public Student updateStudentById(Integer studentId, Student student) {
		
		Student sobj=studentrepository.findById(studentId).get();
		
		if (sobj !=null) {
			sobj.setStudentName(student.getStudentName());
			sobj.setStudentEmailId(student.getStudentEmailId());
			sobj.setStudentDob(student.getStudentDob());
			studentrepository.save(sobj);
			
		}
		
		return sobj;
	}

	@Override
	public String deleteStudentById(Integer studentId) {
		studentrepository.deleteById(studentId);
		return "Student with id="+studentId+" is deleted";
	}


	

	public Student findByStudentEmailId(String studentEmailId) {
		 
			 return studentrepository.findByStudentEmailId(studentEmailId);
		
				 
			
		
		
	}

	@Override
	public Student findByStudentEmailId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findByStudentName(String studentName) {
	    return studentrepository.findByStudentName(studentName);
	}

	@Override
	public StudentDto getStudentDetailDto(Integer studentId) {
		Student sob=studentrepository.findById(studentId).get();
		StudentDto sdto =new StudentDto();
		sdto.setStudentEmailId(sob.getStudentEmailId());
		sdto.setStudentName(sob.getStudentName());
		Course c=sob.getCourse();
		
		return sdto;
	}

	
	
	

}
