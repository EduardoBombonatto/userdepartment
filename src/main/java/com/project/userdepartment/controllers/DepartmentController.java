package com.project.userdepartment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.userdepartment.dto.DepartmentRequestDTO;
import com.project.userdepartment.dto.DepartmentResponseDTO;
import com.project.userdepartment.entities.Department;
import com.project.userdepartment.service.DepartmentService;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@GetMapping
	public List<DepartmentResponseDTO> getAllDepartments() {
		List<Department> originalAllDepartments = departmentService.getAllDepartments();
		return originalAllDepartments.stream().map(dept -> new DepartmentResponseDTO(dept.getId(), dept.getName()))
				.toList();
	}

	@GetMapping(value = "/{id}")
	public DepartmentResponseDTO getDepartmentById(@PathVariable Long id) {
		Department originalDepartment = departmentService.getDepartmentById(id);
		return new DepartmentResponseDTO(originalDepartment.getId(), originalDepartment.getName());
	}

	@PostMapping
	public DepartmentResponseDTO createDepartment(@RequestBody DepartmentRequestDTO departmentDto) {
		Department originalDepartment = departmentService
				.createDepartment(new Department(departmentDto.getId(), departmentDto.getName()));
		return new DepartmentResponseDTO(originalDepartment.getId(), originalDepartment.getName());
	}

	@DeleteMapping(value = "/{id}")
	public void deleteDepartment(Long id) {
		departmentService.deleteDepartment(id);
	}
}
