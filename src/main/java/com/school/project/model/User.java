package com.school.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Column(name = "id")
	@GeneratedValue
	private Long id;
	
	@Column(name = "email", nullable = false, length = 100)
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "created_at")
	private Date createdAt;
	
	@Column(name = "updated_at")
	private Date updatedAt;

}
