package com.example.cs545.Service;

import com.example.cs545.Domain.Course;

import java.util.List;

public interface CourseServiceInt {
    List<Course> getAll();
    void createCourse(Course course);
    void updateCourse(long id, Course course);
    void deleteCourse(long id);
    Course getCourseById(Long id);

}
