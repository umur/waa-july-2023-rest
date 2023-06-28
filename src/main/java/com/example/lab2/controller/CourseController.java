package com.example.lab2.controller;

import com.example.lab2.repository.Course;
import com.example.lab2.service.IUniversityServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/courses")
public class CourseController {

    final IUniversityServices universityServices;


    @PostMapping
    public void addCourse(@RequestBody Course course) {
        universityServices.addCourse(course);
    }

    @DeleteMapping
    public void deleteCourse(@RequestBody Course course) {
        universityServices.deleteCourse(course);
    }

    @GetMapping
    public List<Course> getAllCourse() {
        return universityServices.getAllCourse();
    }
}
