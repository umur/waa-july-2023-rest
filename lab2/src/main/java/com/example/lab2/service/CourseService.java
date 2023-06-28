package com.example.lab2.service;

import com.example.lab2.model.Course;
import com.example.lab2.model.Student;

import java.util.List;

public interface CourseService {
    Course getStudentsByMajor(Long studentId);
    Course getStudentsByCourseId(Long courseId);

}
