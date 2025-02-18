package com.project.userdepartment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.project.userdepartment.utils.ApiResponse;

@RestControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(UserWithCpfAlreadyExists.class)
	private ResponseEntity<ApiResponse<Object>> userWithCpfAlreadyExistHandler(UserWithCpfAlreadyExists exception){
		ApiResponse<Object> errorResponse = new ApiResponse<Object>(HttpStatus.CONFLICT, "CPF ja cadastrado");
		return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
	}
	
	@ExceptionHandler(UserWithEmailAlreadyExists.class)
	private ResponseEntity<ApiResponse<Object>> userWithEmailAlreadyExistHandler(UserWithEmailAlreadyExists exception){
		ApiResponse<Object> errorResponse = new ApiResponse<Object>(HttpStatus.CONFLICT, "Email ja cadastrado");
		return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
	}
	
	@ExceptionHandler(DepartmentNotFound.class)
	private ResponseEntity<ApiResponse<Object>> departmentNotFoundHandler(DepartmentNotFound exception){
		ApiResponse<Object> errorResponse = new ApiResponse<Object>(HttpStatus.NOT_FOUND, "Departamento não encontrado");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}
	
	@ExceptionHandler(UserNotFound.class)
	private ResponseEntity<ApiResponse<Object>> userNotFound(UserNotFound exception){
		ApiResponse<Object> errorResponse = new ApiResponse<Object>(HttpStatus.NOT_FOUND, "Usuário não encontrado");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}
}
