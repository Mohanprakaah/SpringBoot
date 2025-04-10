package com.edu.serive;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.Course;
import com.edu.dao.Student;
import com.edu.dto.StudentDto;
import com.edu.error.GlobalException;
import com.edu.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Integer studentId) throws GlobalException {
        Optional<Student> sobj = studentRepository.findById(studentId);
        if (sobj.isPresent())
            return studentRepository.findById(studentId).get();
        else
            throw new GlobalException("Student with id=" + studentId + " not found");
    }

    @Override
    public String deleteByStudentId(Integer studentId) throws GlobalException {
        if (studentRepository.existsById(studentId)) {
            studentRepository.deleteById(studentId);
            return "Student with id=" + studentId + " is deleted";
        } else {
            throw new GlobalException("Student with id=" + studentId + " not found, cannot delete.");
        }
    }


    @Override
    public Student updateStudentById(Integer studentId, Student student) throws GlobalException {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (optionalStudent.isPresent()) {
            Student existingStudent = optionalStudent.get();
            existingStudent.setStudentName(student.getStudentName());
            existingStudent.setStudentDob(student.getStudentDob());
            existingStudent.setStudentEmailId(student.getStudentEmailId());

            // Save updated student
            return studentRepository.save(existingStudent);
        } else {
            throw new GlobalException("Student with id=" + studentId + " not found, cannot update.");
        }
    }


    

	@Override
	public Student findByStudentEmailId(String studentEmailId) throws GlobalException {
		Student s = studentRepository.findByStudentEmailId(studentEmailId);
		if (s!=null) {
			return studentRepository.findByStudentEmailId(studentEmailId);
		}
		else {
			throw new GlobalException("Student with Email='" + studentEmailId + "' not found.");
		}
		
	}

	@Override
	public List<Student> findByStudentName(String studentName) {
	    return studentRepository.findByStudentName(studentName);
	}

	@Override
	public Student getStudentByEmail(String studentEmailId) {
		// TODO Auto-generated method stub
		return studentRepository.getStudentByEmail(studentEmailId);
	}

	@Override
	public StudentDto getStudentDetailsDto(Integer studentId) {
		Student sob = studentRepository.findById(studentId).get();
		StudentDto sdto = new StudentDto();
		sdto.setStudentEmailId(sob.getStudentEmailId());
		sdto.setStudentName(sob.getStudentName());
		Course c=sob.getCourse();
		sdto.setCourseName(sob.getCourse());
		return sdto;
	}

	@Override
	public List<Student> deleteStudent(Integer studentId) {
		studentRepository.deleteById(studentId);
		return studentRepository.findAll();
	}

	@Override
	public Student findByStudentEmailOrPhone(String email, Long phone) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
	

	

	

	

    
}
