package com.example.assignment_two.service;

import com.example.assignment_two.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();

    void create(Course course);

    void update(Long id, Course course);

    void delete(Long id);
}
