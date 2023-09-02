package com.micro;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "my_collection")
public class MyEntity {
    @Id
    private String id;
    private String name;
    // Other fields, getters, and setters
}

