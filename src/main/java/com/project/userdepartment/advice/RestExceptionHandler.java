package com.project.userdepartment.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.project.userdepartment.exceptions.DepartmentNotFound;
import com.project.userdepartment.exceptions.UserWithCpfAlreadyExists;
import com.project.userdepartment.exceptions.UserWithEmailAlreadyExists;
import com.project.userdepartment.utils.ApiResponse;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
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
}
