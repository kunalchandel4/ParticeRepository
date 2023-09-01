package com.micro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.Entity.Rating;
import com.micro.repo.RatingRepo;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepo repo;

	@Override
	public Rating createRating(Rating object) {
		// TODO Auto-generated method stub
		return repo.save(object);
	}

	@Override
	public List<Rating> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String id) {
		// TODO Auto-generated method stub
		return repo.findByUserId(id);
	}

	@Override
	public List<Rating> getRatingByHotelId(String id) {
		// TODO Auto-generated method stub
		return repo.findByHotelId(id);
	}

}
