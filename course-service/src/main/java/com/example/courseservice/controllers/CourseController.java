package com.example.courseservice.controllers;

import com.example.courseservice.services.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    @Autowired
    private ICourseService courseService;
}