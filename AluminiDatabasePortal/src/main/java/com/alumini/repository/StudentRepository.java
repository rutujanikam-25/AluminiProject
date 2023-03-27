package com.alumini.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alumini.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	List<Student> findByNameContaining(String sName);
	List<Student> findByGraduationYearContaining(String sGraduationYear);
	
}
