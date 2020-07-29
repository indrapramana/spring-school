package com.school.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {

	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
}
