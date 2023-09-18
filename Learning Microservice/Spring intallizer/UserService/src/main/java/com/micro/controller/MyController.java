package com.micro.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.entities.User;
import com.micro.exception.UserException;
import com.micro.service.UserService;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/user")

public class MyController {

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		String uuid = UUID.randomUUID().toString();
		user.setUserId(uuid);
		User savedUser = userService.saveUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAllUser();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@GetMapping("/{id}")
//	@CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelfallbackMethod")
	@Retry(name = "ratingHotelRetry",fallbackMethod = "ratingHotelfallbackMethod")
	public ResponseEntity<User> getUserById(@PathVariable String id) throws UserException {

		User user = userService.getUser(id);
		return new ResponseEntity<>(user, HttpStatus.OK);

	}
	
	public ResponseEntity<User> ratingHotelfallbackMethod(String id, Exception ex)  {

		User user = new User();
		user.setAbout("Service is down baby");
		return new ResponseEntity<>(user, HttpStatus.OK);

	}
}
