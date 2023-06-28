package com.example.demo.service;

import com.example.demo.entity.Course;

import java.util.List;

public interface CourseService {
    void create(Course course);

    List<Course> findAll();

    void update(Course course);

    Course getCourse(Long id);

    void delete(Long id);
}
