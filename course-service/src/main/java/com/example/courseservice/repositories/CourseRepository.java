package com.example.courseservice.repositories;

import com.example.courseservice.entities.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends MongoRepository<Course, String> {
    public List<Course> findByName(String name);
    public List<Course> findByCategory(String category);
}

