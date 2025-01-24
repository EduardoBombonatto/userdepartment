package com.project.userdepartment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.userdepartment.entities.Department;
import com.project.userdepartment.exceptions.DepartmentNotFound;
import com.project.userdepartment.repositories.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department createDepartment(Department user) {
		return departmentRepository.save(user);
	}

	@Override
	public Department getDepartmentById(Long id) {
		if (!departmentRepository.existsById(id)) {
			throw new DepartmentNotFound();
		}
		return departmentRepository.findById(id).get();
	}

	@Override
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public Department deleteDepartment(Long id) {
		if (!departmentRepository.existsById(id)) {
			throw new DepartmentNotFound();
		}

		Department dept = this.getDepartmentById(id);
		departmentRepository.deleteById(id);
		return dept;
	}
}
