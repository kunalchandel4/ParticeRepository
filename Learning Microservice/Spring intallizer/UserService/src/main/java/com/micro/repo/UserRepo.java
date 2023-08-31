package com.micro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.micro.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> 
{

}
