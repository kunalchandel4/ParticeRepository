package com.micro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.micro.entity.Hotel;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, String> {

}
