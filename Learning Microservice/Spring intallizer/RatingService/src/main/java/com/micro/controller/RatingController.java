package com.micro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.Entity.Rating;
import com.micro.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ser;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Rating rate) {

		return new ResponseEntity<>(ser.createRating(rate), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<?> getALl() {

		return new ResponseEntity<>(ser.getAll(), HttpStatus.OK);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUserID(@PathVariable String id) {

		return new ResponseEntity<>(ser.getRatingByUserId(id), HttpStatus.OK);
	}

	@GetMapping("/hotels/{id}")
	public ResponseEntity<?> getHotelId(@PathVariable String id) {

		return new ResponseEntity<>(ser.getRatingByHotelId(id), HttpStatus.OK);
	}

}
