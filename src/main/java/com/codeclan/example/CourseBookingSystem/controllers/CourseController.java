package com.codeclan.example.CourseBookingSystem.controllers;

import com.codeclan.example.CourseBookingSystem.models.Course;
import com.codeclan.example.CourseBookingSystem.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getAllCourses(
            @RequestParam(name="rating", required = false) Integer rating,
            @RequestParam(name = "customer", required = false) String customer) {
        if (rating != null) {
            return new ResponseEntity<>(courseRepository.findCoursesByRating(rating), HttpStatus.OK);
        }
        if (customer != null){
            return new ResponseEntity<>(courseRepository.findCoursesByBookingsCustomersNameIgnoreCase(customer), HttpStatus.OK);
        }
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/courses/{id}")
    public ResponseEntity getCourse(@PathVariable Long id){
        return new ResponseEntity<>(courseRepository.findById(id),HttpStatus.OK);
    }
    @PostMapping(value = "/courses")
    public ResponseEntity<Course> postCourse(@RequestBody Course course){
        courseRepository.save(course);
        return new ResponseEntity<>(course,HttpStatus.CREATED);
    }

}
