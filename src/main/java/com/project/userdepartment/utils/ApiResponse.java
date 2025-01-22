package com.project.userdepartment.utils;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
	private HttpStatus statusCode;
	private String message;
	private T data;
	
	public ApiResponse() {
	}

	//Errors constructor
	public ApiResponse(HttpStatus statusCode, String message) {
		this.statusCode = statusCode;
		this.message = message;
	}

	//Succeed request constructor
	public ApiResponse(HttpStatus statusCode, String message, T data) {
		this.statusCode = statusCode;
		this.message = message;
		this.data = data;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
}
