package com.project.userdepartment.exceptions;

@SuppressWarnings("serial")
public class DepartmentNotFound extends RuntimeException{
	public DepartmentNotFound() {
		super("Departamento não encontrado");
	}
	
	public DepartmentNotFound(String message) {
		super(message);
	}
}
