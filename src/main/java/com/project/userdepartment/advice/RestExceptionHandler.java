package com.project.userdepartment.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.project.userdepartment.exceptions.DepartmentNotFound;
import com.project.userdepartment.exceptions.UserWithCpfAlreadyExists;
import com.project.userdepartment.exceptions.UserWithEmailAlreadyExists;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(UserWithCpfAlreadyExists.class)
	private ResponseEntity<String> userWithCpfAlreadyExistHandler(UserWithCpfAlreadyExists exception){
		return ResponseEntity.status(HttpStatus.CONFLICT).body("CPF ja cadastrado");
	}
	
	@ExceptionHandler(UserWithEmailAlreadyExists.class)
	private ResponseEntity<String> userWithEmailAlreadyExistHandler(UserWithEmailAlreadyExists exception){
		return ResponseEntity.status(HttpStatus.CONFLICT).body("Email ja cadastrado");
	}
	
	@ExceptionHandler(DepartmentNotFound.class)
	private ResponseEntity<String> departmentNotFoundHandler(DepartmentNotFound exception){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("departamento não encontrado");
	}
}
