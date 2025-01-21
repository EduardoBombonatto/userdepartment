package com.project.userdepartment.dto;

import com.project.userdepartment.entities.Department;

public class UserRequestDTO {

	private Long id;
	private String name;
	private String email;
	private String cpf;
	private Department department;

	public UserRequestDTO() {
	}

	public UserRequestDTO(Long id, String name, String email, String cpf, Department department) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpf = cpf;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}
