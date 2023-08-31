package com.micro.service;

import java.util.List;

import com.micro.entities.User;
import com.micro.exception.UserException;

public interface UserService {

	public User saveUser(User object);

	public List<User> getAllUser();

	public User getUser(String id) throws UserException;
	
	// Todo: update Delete
}
