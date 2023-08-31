package com.micro.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "hotels")
public class Hotel {

	@Id
	private Integer id;
	private String name;
	private String location;
	private String about;

}
