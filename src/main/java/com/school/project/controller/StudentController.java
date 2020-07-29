package com.school.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.project.exception.RecordNotFoundException;
import com.school.project.model.Student;
import com.school.project.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentService service;
	
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents() throws RecordNotFoundException {
		List<Student> list = service.getAllStudents();
		return new ResponseEntity<List<Student>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id) throws RecordNotFoundException  {
		Student entity = service.getStudentById(id);
		return new ResponseEntity<Student>(entity, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Student> createOrUpdateStudent(@RequestBody Student student) throws RecordNotFoundException {
		Student entity = service.createOrUpdate(student);
		return new ResponseEntity<Student>(entity, new HttpHeaders(), HttpStatus.OK);
	}
	
	@DeleteMapping
	public HttpStatus deleteStudentById(@PathVariable("id") Long id) throws RecordNotFoundException  {
		service.deleteStudentById(id);
		return HttpStatus.FORBIDDEN;
	}
	
}
