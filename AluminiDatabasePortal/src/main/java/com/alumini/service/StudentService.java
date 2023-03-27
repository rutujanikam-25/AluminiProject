package com.alumini.service;

import java.util.List;

import com.alumini.entity.Student;
import com.alumini.studentdto.StudentDTO;

public interface StudentService {
	List<Student> getAllStudent();
	Student createStudent(StudentDTO studentDTO);
	Student updateStudent(int id,StudentDTO studentDTO);
	Student getStudentBySId(int id);
	List<Student> findBySNameContaining(String name);
	List<Student> findBySGraduationYearContaining(String graduationYear);
	String deleteStudent(int id);

}
