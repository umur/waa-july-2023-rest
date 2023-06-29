package com.example.backend.service;

import com.example.backend.entity.Course;

import java.util.Iterator;
import java.util.List;

public interface CourseService {
    void create(Course course);
    Course getById(Long id);
    List<Course> getAll();
    void update(Course course);
    void delete(Long id);
}
