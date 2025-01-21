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

import com.project.userdepartment.dto.UserRequestDTO;
import com.project.userdepartment.dto.UserResponseDTO;
import com.project.userdepartment.entities.User;
import com.project.userdepartment.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public List<UserResponseDTO> getAllUsers() {
		List<User> originalAllUsers = userService.getAllUsers();
		return originalAllUsers.stream()
				.map(user -> new UserResponseDTO(user.getId(), user.getName(), user.getEmail(), user.getDepartment()))
				.toList();

	}

	@GetMapping(value = "/{id}")
	public UserResponseDTO getUserById(@PathVariable("id") Long id) {
		User originalUser = userService.getUserById(id);
		return new UserResponseDTO(originalUser.getId(), originalUser.getName(), originalUser.getEmail(),
				originalUser.getDepartment());
	}

	@PostMapping
	public UserResponseDTO createUser(@RequestBody UserRequestDTO userDto) {
		User createdUser = userService.createUser(new User(userDto.getId(), userDto.getName(), userDto.getEmail(),
				userDto.getCpf(), userDto.getDepartment()));

		return new UserResponseDTO(createdUser.getId(), createdUser.getName(), createdUser.getEmail(),
				createdUser.getDepartment());
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
}
