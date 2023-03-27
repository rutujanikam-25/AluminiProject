package com.alumini.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alumini.entity.Student;
import com.alumini.exception.UserNotFoundException;
import com.alumini.repository.StudentRepository;
import com.alumini.service.StudentService;
import com.alumini.studentdto.StudentDTO;

@Service
public class StudentServiceImpl implements StudentService {
 
	@Autowired
	private StudentRepository studentRepository;
	
	
	@Override
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	@Override
	public Student createStudent(StudentDTO studentDTO) {
		Student student=Student.builder().name(studentDTO.getName()).email(studentDTO.getEmail()).phone(studentDTO.getPhone()).graduationYear(studentDTO.getGraduationYear()).address(studentDTO.getAddress()).build();
		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(int id, StudentDTO studentDTO) //throws UserNotFoundException
	{
		Optional<Student> sdata=studentRepository.findById(id);
		if(sdata.isEmpty()) {
			Student _student=studentRepository.findById(id).get();
			_student.setName(studentDTO.getName());
			_student.setPhone(studentDTO.getPhone());
			_student.setEmail(studentDTO.getEmail());
			_student.setGraduationYear(studentDTO.getGraduationYear());
			_student.setAddress(studentDTO.getAddress());
			
			return studentRepository.save(_student);
		}
		
	else throw new UserNotFoundException("No user bearing id"+id+"can be found");
	}

	@Override
	public Student getStudentBySId(int id) {
		return studentRepository.findById(id).orElseThrow(()->new UserNotFoundException("No User hearing id"+id+"can be found"));
	}

	@Override
	public List<Student> findBySNameContaining(String name) throws  UserNotFoundException
	{
		if(studentRepository.findByNameContaining(name).isEmpty())
			throw new UserNotFoundException("No User bearing"+name+"can be found");
		else
			return studentRepository.findByNameContaining(name);
	}

	@Override
	public List<Student> findBySGraduationYearContaining(String graduationYear) {
		if(studentRepository.findByGraduationYearContaining(graduationYear).isEmpty())
			throw new UserNotFoundException("No student with graduation "+graduationYear+"can be found");
		else
		    return studentRepository.findByGraduationYearContaining(graduationYear);
	}

	@Override
	public String deleteStudent(int id) {
		studentRepository.deleteById(id);
		return "Student bearing id"+id+"has been deleted successfully..............";
	}
   
}
