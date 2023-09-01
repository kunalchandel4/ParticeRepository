package com.micro.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.micro.Entity.Rating;

@Repository
public interface RatingRepo extends MongoRepository<Rating, String> {

	// custome Method

	List<Rating> findByUserId(String id);

	List<Rating> findByHotelId(String id);

}
