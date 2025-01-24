package com.project.userdepartment.service;

import java.util.List;

import com.project.userdepartment.entities.Department;

public interface DepartmentService {
	Department createDepartment(Department user);

	Department getDepartmentById(Long id);

	List<Department> getAllDepartments();

	Department deleteDepartment(Long id);
}
