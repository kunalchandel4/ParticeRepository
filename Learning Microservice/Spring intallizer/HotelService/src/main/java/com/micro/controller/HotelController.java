package com.micro.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.entity.Hotel;
import com.micro.exception.HotelException;
import com.micro.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	@Autowired
	private HotelService userService;

	@PreAuthorize("hasAuthority('Admin')")
	@PostMapping
	public ResponseEntity<Hotel> saveUser(@RequestBody Hotel Hotel) {
		String uuid = UUID.randomUUID().toString();
		Hotel.setId(uuid);
		Hotel savedHotel = userService.create(Hotel);
		return new ResponseEntity<>(savedHotel, HttpStatus.CREATED);
	}

	@PreAuthorize("hasAuthority('SCOPE_internal')")
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllUsers() {
		List<Hotel> users = userService.getAll();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	// get all
	@PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getUserById(@PathVariable String id) throws HotelException {

		Hotel user = userService.get(id);
		return new ResponseEntity<>(user, HttpStatus.OK);

	}
}
