package com.miu.edu.service;

import com.miu.edu.model.Course;

import java.util.List;


public interface CourseService {
    public void create(Course course);

    public List<Course> getAll();

    public Course getById(Long id);


}
