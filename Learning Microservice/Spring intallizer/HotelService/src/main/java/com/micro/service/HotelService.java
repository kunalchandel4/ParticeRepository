package com.micro.service;

import java.util.List;

import com.micro.entity.Hotel;
import com.micro.exception.HotelException;

public interface HotelService {

	Hotel create(Hotel hotel);

	List<Hotel> getAll();

	Hotel get(String id) throws HotelException;
}
