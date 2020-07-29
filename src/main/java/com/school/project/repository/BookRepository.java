package com.school.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.project.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
