package com.project.userdepartment.dto;

public class DepartmentRequestDTO {
	private Long id;
	private String name;
	
	public DepartmentRequestDTO() {
	}

	public DepartmentRequestDTO(Long id, String name) {
		this.id = id;
		this.name = name;
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
	
	
}
