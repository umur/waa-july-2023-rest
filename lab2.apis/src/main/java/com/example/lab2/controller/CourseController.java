package com.example.lab2.controller;

import com.example.lab2.entity.Course;
import com.example.lab2.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping
    public void create(@RequestBody Course course) {
        courseService.create(course);
    }

    @GetMapping
    public List<Course> getAll() {
        var result = courseService.getAll();
        return result;
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {

        return courseService.getById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Course course) {
        courseService.update(id, course);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        courseService.delete(id);
    }

}
