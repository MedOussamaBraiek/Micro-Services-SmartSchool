package com.example.courseservice.services;

import com.example.courseservice.entities.Course;
import com.example.courseservice.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements ICourseService {
    @Autowired
    private CourseRepository courseRepository;


    public List<Course> getCourses() {

        return courseRepository.findAll();
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public String deleteCourse(String id) {
        courseRepository.deleteById(id);;
        return "Course deleted successfuly";
    }

    public Course updateCourseByOwner(String id, Course newCourse) {
		Course c = courseRepository.findById(id).get();
		if(newCourse.getName()!= null) {
			c.setName(newCourse.getName());
		}
		if(newCourse.getDescription()!= null) {
			c.setDescription(newCourse.getDescription());
		}
		if(newCourse.getCategory()!= null) {
			c.setCategory(newCourse.getCategory());
		}
		return courseRepository.save(c);
	
	}

    public Course getCourseById(String id) {
		return courseRepository.findById(id).get();
	}

    public List<Course> getCoursesByName(String name) {
        List<Course>courses=courseRepository.getCoursesByName(name);
		return courses;
	}

    // public List<Course> getCoursesByOwner(String ownerId) {
	// 	List<Course>courses=courseRepository.findReclamationsByOwnerId(ownerId);
	// 	return courses;
	// }
}



