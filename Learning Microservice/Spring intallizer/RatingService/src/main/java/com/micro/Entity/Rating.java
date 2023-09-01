package com.micro.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.Data;

@Document("user_rating")
@Data
public class Rating {

	@Id
	private String ratingId;
	private String userId;
	private String hotelId;
	private Integer rating;
	private String feedback;

}
