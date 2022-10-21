package com.example.courseservice.services;

import com.example.courseservice.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService implements ICourseService {
@Autowired
private CourseRepository courseRepository;
}



