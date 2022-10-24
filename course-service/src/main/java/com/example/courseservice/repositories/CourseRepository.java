package com.example.courseservice.repositories;

import com.example.courseservice.entities.Course;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
public interface CourseRepository extends MongoRepository<Course, String> {

    @Query("{name : ?0}")                                         // SQL Equivalent : SELECT * FROM BOOK where author = ?
    List<Course> getCoursesByName(String name);

    
}

