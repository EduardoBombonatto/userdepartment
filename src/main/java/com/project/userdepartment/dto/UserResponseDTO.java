package com.project.userdepartment.dto;

import com.project.userdepartment.entities.Department;

public class UserResponseDTO {

	private Long id;
	private String name;
	private String email;
	private Department department;

	public UserResponseDTO(Long id, String name, String email, Department department) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.department = department;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}
