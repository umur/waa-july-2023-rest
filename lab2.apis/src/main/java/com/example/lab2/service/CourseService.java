package com.example.lab2.service;

import com.example.lab2.entity.Course;

import java.util.List;

public interface CourseService {
    public void create(Course course);
    public void update(long id,Course course);
    public void delete(long id);
    public Course getById(long id);
    public List<Course> getAll();
}
