package com.example.lab2.service.impl;

import com.example.lab2.model.Course;
import com.example.lab2.model.Student;
import com.example.lab2.repository.CourseRepository;
import com.example.lab2.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Override
    public Course getStudentsByMajor(Long studentId) {
        return courseRepository.getReferenceById(studentId);
    }

    @Override
    public Course getStudentsByCourseId(Long courseId) {
        return courseRepository.getReferenceById(courseId);
    }


}
