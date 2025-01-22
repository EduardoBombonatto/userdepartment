package com.project.userdepartment.exceptions;

@SuppressWarnings("serial")
public class UserWithEmailAlreadyExists extends RuntimeException {
	public UserWithEmailAlreadyExists() {
		super("Email já cadastrado");
	}

	public UserWithEmailAlreadyExists(String message) {
		super(message);
	}
}
