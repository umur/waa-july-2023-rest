package com.miu.edu.controller;

import com.miu.edu.model.Course;
import com.miu.edu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService service;

    @PostMapping
    public void add(@RequestBody Course course) {
        service.create(course);
    }

    @GetMapping()
    public List<Course> getAll(){
        return service.getAll();
    }


    @GetMapping("/{id}")
    public Course getById(@PathVariable Long id){
        return service.getById(id);
    }



}
