package com.micro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.micro.entity.Hotel;
import com.micro.exception.HotelException;
import com.micro.repo.HotelRepo;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepo hR;

	@Override
	public Hotel create(Hotel hotel) {
		// TODO Auto-generated method stub
		return hR.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		// TODO Auto-generated method stub
		return hR.findAll();
	}

	@Override
	public Hotel get(String id) throws HotelException {
		// TODO Auto-generated method stub

		return hR.findById(id).orElseThrow(() -> new HotelException("Id Doesn't exists"));

	}

}
