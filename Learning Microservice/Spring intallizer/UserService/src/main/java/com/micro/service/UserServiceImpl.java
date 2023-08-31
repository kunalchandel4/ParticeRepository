package com.micro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.entities.User;
import com.micro.exception.UserException;
import com.micro.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo uR;

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
		return uR.findById(id).orElseThrow(()-> new UserException("Not found " + id));
	}

}
