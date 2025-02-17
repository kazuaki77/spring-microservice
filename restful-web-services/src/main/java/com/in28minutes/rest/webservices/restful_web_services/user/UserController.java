package com.in28minutes.rest.webservices.restful_web_services.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return userService.findAll();
	}

	@GetMapping("/user/{id}")
	public User retrieveUser(@PathVariable Long id) {
		User user = userService.findUserById(id);

		if (user == null) {
			throw new UserNotFoundException("id: " + id);
		}

		return user;
	}

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		userService.save(user);

		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable Long id) {
		User user = userService.findUserById(id);
		if (user == null) {
			throw new UserNotFoundException("id:" + id);
		}
		userService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

}
