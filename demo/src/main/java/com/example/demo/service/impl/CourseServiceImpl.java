package com.example.demo.service.impl;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }

    public Course getCourseById(int id) {
        return courseRepository.getCourseById(id);
    }

    public void addCourse(Course course) {
        courseRepository.addCourse(course);
    }

    public void updateCourse(Course updatedCourse) {
        courseRepository.updateCourse(updatedCourse);
    }

    public void deleteCourse(int id) {
        courseRepository.deleteCourse(id);
    }


}
