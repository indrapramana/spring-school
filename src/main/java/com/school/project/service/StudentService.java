package com.school.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.project.exception.RecordNotFoundException;
import com.school.project.model.Student;
import com.school.project.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository repository;
	
	public List<Student> getAllStudents() {
		List<Student> studentList = repository.findAll();
		
		if (studentList.size() > 0) {
			return studentList;
		} else {
			return new ArrayList<Student>();
		}
	}
	
	public Student getStudentById(Long id) throws RecordNotFoundException {
		Optional<Student> student = repository.findById(id);
		
		if (student.isPresent()) {
			return student.get();
		} else {
			throw new RecordNotFoundException("No student record exist for given id", id);
		}
	}
	
	public Student createOrUpdate(Student entity) throws RecordNotFoundException {
		if (entity.getId() != null) {
			Optional<Student> student = repository.findById(entity.getId());
		
			if (student.isPresent()) {
				Student object = student.get();
				object.setEmail(entity.getEmail());
				object.setName(entity.getName());
				
				return repository.save(object);
				
			} else {
				return repository.save(entity);
			}
		} else {
			return repository.save(entity);
		}	
	}
	
	public void deleteStudentById(Long id) throws RecordNotFoundException {
		
		Optional<Student> student = repository.findById(id);
		
		if (student.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No student record exist for given id",id);
		}
	}
	
}
