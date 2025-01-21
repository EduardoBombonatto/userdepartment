package com.project.userdepartment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.userdepartment.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
