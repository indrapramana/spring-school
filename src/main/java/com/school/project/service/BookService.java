package com.school.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.project.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository repository;
	
	
}
