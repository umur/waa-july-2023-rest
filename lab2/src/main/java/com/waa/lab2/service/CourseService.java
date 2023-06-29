package com.waa.lab2.service;

import com.waa.lab2.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    List<Course> getAllCourses();
    String addCourse(Course course);
    String deleteCourse(Long id);
    String updateCourse(Long id,Course course);
    List<Course> getCourseByStudentId(Long studentId);
}
