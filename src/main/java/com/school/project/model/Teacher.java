package com.school.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "teachers")
public class Teacher {
	
	@Column(name = "id")
	@GeneratedValue
	private Long id;
	
	@Column(name = "number")
	private String number;

	@Column(name = "name")
	private String name;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Gender gender;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	@Column(name = "created_at")
	private Date createdAt;
	
	@Column(name = "updated_at")
	private Date updatedAt;
}
