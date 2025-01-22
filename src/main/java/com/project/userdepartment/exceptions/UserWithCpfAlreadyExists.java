package com.project.userdepartment.exceptions;

@SuppressWarnings("serial")
public class UserWithCpfAlreadyExists extends RuntimeException {
	public UserWithCpfAlreadyExists() {
		super("CPF já cadastrado");
	}

	public UserWithCpfAlreadyExists(String message) {
		super(message);
	}
}
