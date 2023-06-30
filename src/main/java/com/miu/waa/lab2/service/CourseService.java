package com.miu.waa.lab2.service;

import java.util.List;

import com.miu.waa.lab2.entity.Course;

public interface CourseService {

    public Course create(Course course);

    public Course update(Course course);

    public Course delete(Long id);

    public Course findById(Long id);

    public List<Course> findAll();
}
