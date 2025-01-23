package com.project.userdepartment.exceptions;

@SuppressWarnings("serial")
public class UserNotFound extends RuntimeException {
	public UserNotFound() {
		super("Usuário não encontrado no banco de dados");
	}

	public UserNotFound(String message) {
		super(message);
	}
}
