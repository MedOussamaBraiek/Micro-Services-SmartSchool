package com.example.courseservice.controllers;

import com.example.courseservice.entities.Course;
import com.example.courseservice.services.CourseService;
import com.example.courseservice.services.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/all")
    public ResponseEntity<List<Course>> getCourses(){
        return new ResponseEntity<List<Course>>(courseService.getCourses(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Course> addCourse (@RequestBody Course course){
        return new ResponseEntity<Course>(courseService.addCourse(course),HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
	public ResponseEntity<Course> updateCourseByOwner (@PathVariable("id") String id,@RequestBody Course course){
		return new ResponseEntity<Course>(courseService.updateCourseByOwner(id, course),HttpStatus.OK);
	}

    @DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCourse (@PathVariable("id") String id){
        if(courseService.getCourseById(id) != null)
		return new ResponseEntity<String>(courseService.deleteCourse(id),HttpStatus.OK);
        else
        return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}

    @GetMapping("/{id}")
	public ResponseEntity<Course>getReclamation(@PathVariable("id") String id){
		return new ResponseEntity<Course>(courseService.getCourseById(id),HttpStatus.OK);
	}
	@GetMapping("/title")
	public ResponseEntity<List<Course>>getReclamationsByTitle(@RequestParam("name")String name){
		return new ResponseEntity<List<Course>>(courseService.getCoursesByName(name),HttpStatus.OK);
	}
}
