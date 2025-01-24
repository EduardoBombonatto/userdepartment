package com.project.userdepartment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.project.userdepartment.utils.ApiResponse;

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
	public ResponseEntity<ApiResponse<DepartmentResponseDTO>> getDepartmentById(@PathVariable Long id) {
		Department originalDepartment = departmentService.getDepartmentById(id);
		DepartmentResponseDTO returnedDeparment = new DepartmentResponseDTO(originalDepartment.getId(),
				originalDepartment.getName());

		return ResponseEntity.ok(new ApiResponse<DepartmentResponseDTO>(HttpStatus.OK, "Usuário retornado com sucesso",
				returnedDeparment));
	}

	@PostMapping
	public ResponseEntity<ApiResponse<DepartmentResponseDTO>> createDepartment(@RequestBody DepartmentRequestDTO departmentDto) {
		Department originalDepartment = departmentService
				.createDepartment(new Department(departmentDto.getId(), departmentDto.getName()));
		DepartmentResponseDTO returnedDeparment = new DepartmentResponseDTO(originalDepartment.getId(),
				originalDepartment.getName());
		
		return ResponseEntity.ok(new ApiResponse<DepartmentResponseDTO>(HttpStatus.OK, "Usuário retornado com sucesso",
				returnedDeparment));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ApiResponse<DepartmentResponseDTO>> deleteDepartment(Long id) {
		Department deletedDepartment = departmentService.deleteDepartment(id);
		DepartmentResponseDTO returnedDeparment = new DepartmentResponseDTO(deletedDepartment.getId(),
				deletedDepartment.getName());

		return ResponseEntity.ok(new ApiResponse<DepartmentResponseDTO>(HttpStatus.OK, "Usuário retornado com sucesso",
				returnedDeparment));
	}
}
