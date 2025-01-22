package com.project.userdepartment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.userdepartment.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	boolean existsById(Long id);
}
