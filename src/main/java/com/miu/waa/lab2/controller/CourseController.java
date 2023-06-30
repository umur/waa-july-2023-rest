package com.miu.waa.lab2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miu.waa.lab2.entity.Course;
import com.miu.waa.lab2.service.CourseService;
import com.miu.waa.lab2.service.StudentService;

@RestController
@RequestMapping("/courses/")
public class CourseController {
    @Autowired
    CourseService courseService;

    @Autowired
    StudentService studentService;

    @PostMapping
    public Course create(@RequestBody Course course) {
        return courseService.create(course);
    }

    @GetMapping
    public List<Course> findAll(Long studentId) {
        return courseService.findAll();
    }

    @PutMapping("{id}")
    public Course update(@PathVariable Long id, @RequestBody Course course) {
        course.setId(id);
        return courseService.update(course);
    }

    @DeleteMapping("{id}")
    public Course delete(@PathVariable Long id) {
        return courseService.delete(id);
    }

    @GetMapping("{id}")
    public Course findById(@PathVariable Long id) {
        return courseService.findById(id);
    }
}
