package com.waa_lab2.backend.service;

import com.waa_lab2.backend.model.Course;

import java.util.List;

public interface CourseService {
    void create (Course course);
    List<Course> getAll();
    Course getByID (int courseId);
    void update (int courseId,Course course);
    void delete (int courseId);

}
