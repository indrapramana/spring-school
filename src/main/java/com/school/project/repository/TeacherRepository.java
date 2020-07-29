package com.school.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.project.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
