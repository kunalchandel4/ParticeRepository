package com.micro.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.micro.entities.Hotel;
import com.micro.entities.Rating;
import com.micro.entities.User;
import com.micro.exception.UserException;
import com.micro.externalService.HotelService;
import com.micro.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo uR;
	@Autowired
	private RestTemplate restTemp;

	@Autowired
	private HotelService hotelService;

	@Override
	public User saveUser(User object) {
		// TODO Auto-generated method stub

		return uR.save(object);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub

		return uR.findAll();
	}

	@Override
	public User getUser(String id) throws UserException {
		// TODO Auto-generated method stub
		User theObject = uR.findById(id).orElseThrow(() -> new UserException("Not found " + id));
		Rating[] ratingArray = restTemp.getForObject("http://RATING-SERVICE/ratings/user/" + theObject.getUserId(),
				Rating[].class);

		List<Rating> ratingOfUser = Arrays.stream(ratingArray).toList();

		ratingOfUser.stream().map(rating -> {
			// http://localhost:9002/hotels/2550c591-7be2-4b1d-8b83-70668a821c11
//			  Hotel hotel =  restTemp.getForObject("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			// set hotel to the rating
			rating.setHotel(hotel);
			// return rating
			return rating;
		}).collect(Collectors.toList());

		theObject.setRating(ratingOfUser);

		return theObject;
	}

}
