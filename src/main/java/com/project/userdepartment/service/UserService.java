package com.project.userdepartment.service;

import java.util.List;

import com.project.userdepartment.entities.User;

public interface UserService {
	User createUser(User user);

	User getUserById(Long id);

	List<User> getAllUsers();

	void deleteUser(Long id);
}
