package com.micro.service;

import java.util.List;

import com.micro.Entity.Rating;

public interface RatingService {

	// create

	Rating createRating(Rating object);

	// get all rating

	List<Rating> getAll();
	// get all by UserID

	List<Rating> getRatingByUserId(String id);
	// get all by Hotel

	List<Rating> getRatingByHotelId(String id);

}
