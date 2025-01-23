package com.project.userdepartment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.userdepartment.entities.User;
import com.project.userdepartment.exceptions.DepartmentNotFound;
import com.project.userdepartment.exceptions.UserNotFound;
import com.project.userdepartment.exceptions.UserWithCpfAlreadyExists;
import com.project.userdepartment.exceptions.UserWithEmailAlreadyExists;
import com.project.userdepartment.repositories.DepartmentRepository;
import com.project.userdepartment.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public User createUser(User user) {
		if (userRepository.existsByEmail(user.getEmail())) {
			throw new UserWithEmailAlreadyExists();
		}

		if (userRepository.existsByCpf(user.getCpf())) {
			throw new UserWithCpfAlreadyExists();
		}

		if (!departmentRepository.existsById(user.getDepartment().getId())) {
			throw new DepartmentNotFound();
		}

		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long id) {
		if (!userRepository.existsById(id)) {
			throw new UserNotFound();
		}

		return userRepository.findById(id).get();
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User deleteUser(Long id) {
		if (!userRepository.existsById(id)) {
			throw new UserNotFound();
		}

		User user = this.getUserById(id);
		userRepository.deleteById(id);
		
		return user;
	}
}
