package com.example.demo.service;

import com.example.demo.entity.Course;

import java.util.List;

public interface CourseService {

    public List<Course> getAllCourses();
    public Course getCourseById(int id);
    public void addCourse(Course course);
    public void updateCourse(Course updatedCourse);
    public void deleteCourse(int id);
}
