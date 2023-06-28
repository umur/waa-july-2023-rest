package com.example.lab2.controller;

import com.example.lab2.model.Course;
import com.example.lab2.model.Student;
import com.example.lab2.service.CourseService;
import com.example.lab2.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/courses")
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseServiceImpl courseService;
    @GetMapping("/students/{studentId}")
    public Course getStudentsByMajor(@PathVariable Long studentId) {
        return courseService.getStudentsByMajor(studentId);
    }
    @GetMapping("/students/{courseId}")
    public Course getStudentsByCourseId(@PathVariable Long courseId) {
        return courseService.getStudentsByCourseId(courseId);
    }
}
