package com.alumini.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alumini.entity.Student;
import com.alumini.service.StudentService;
import com.alumini.studentdto.StudentDTO;

@RestController
@RequestMapping("/api")
public class StudentController {
	@Autowired
	
	
  private StudentService studentService;
  
  @PostMapping("/students/add")
  public ResponseEntity<Student> createStudent(@RequestBody @Valid StudentDTO a){
	  Student a1=studentService.createStudent(a);
	  return new ResponseEntity<>(a1,HttpStatus.CREATED);
  }
  
  @PutMapping("/students/{id}")
  public ResponseEntity<Student> updateStudent(@PathVariable("id")int id,@RequestBody StudentDTO studentDTO)
  {
	  studentService.updateStudent(id, studentDTO);
	  return ResponseEntity.ok().body(studentService.updateStudent(id, studentDTO));
  }
  
  @GetMapping("/studentname")
  public ResponseEntity<List<Student>> getStudentByStd_Name(@RequestParam(required=false)String sName){
	  List<Student> student=studentService.findBySNameContaining(sName);
	  return ResponseEntity.ok(student);
  }
  
  @DeleteMapping("/students/{id}")
  public ResponseEntity<Student> deleteStudent(@PathVariable int id){
	  studentService.deleteStudent(id);
	  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
  @GetMapping("/students")
  public ResponseEntity<List<Student>> fetchAllStudents(){
	  List<Student> student=studentService.getAllStudent();
	  
	  return ResponseEntity.ok(student); 
  }
  
  
}

