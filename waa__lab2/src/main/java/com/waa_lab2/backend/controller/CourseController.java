package com.waa_lab2.backend.controller;

import com.waa_lab2.backend.model.Course;
import com.waa_lab2.backend.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin       // allow cross-origin request i.e.requests from a domain different from the domain serving the web application.
@RestController    // Spring understands that this class will be responsible for handling RESTful requests and generating the response directly as the HTTP response body
@ResponseBody      // indicate that the return value of a method should be serialized and included directly in the HTTP response body
//It's important to note that when using @RestController, which is a specialized version of @Controller, the @ResponseBody annotation is not required
@RequestMapping("/courses") // used at the class level to specify the base URL mapping for all the methods(GET,PUT...) in this controller

public class CourseController {
    // initializing courseService
    @Autowired
    private CourseService courseService;

    // handling post request
    @PostMapping // Create-->post
    public void createCourse(@RequestBody Course course){
        courseService.create(course);
    }

    // handling get request
    @GetMapping // Read-- get
    public List<Course> getAllCourses(){
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public Course getCoursesByStudentId(@PathVariable int id){
        return courseService.getByID(id);
    }

    // handling put request
    @PutMapping("/{id}") // Update--> put
    public void updateCourse(@PathVariable int id, @RequestBody Course course){
        courseService.update(id,course);
    }

    // handling delete request
    @DeleteMapping("/{id}") // Delete--> delete
    public void deleteCourse(@PathVariable int id){
        courseService.delete(id);
    }

}
