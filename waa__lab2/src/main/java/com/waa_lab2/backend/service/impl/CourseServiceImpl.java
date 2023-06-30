package com.waa_lab2.backend.service.impl;

import com.waa_lab2.backend.model.Course;
import com.waa_lab2.backend.repository.CourseRepository;
import com.waa_lab2.backend.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor // part of Lombok library that generates a constructor with parameters for all final fields or fields marked with the @NonNull annotation.
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    @Override
    public void create(Course course) {
        courseRepository.save(course);
    }

    @Override
    public List<Course> getAll() {
        return courseRepository.getAll();
    }

    @Override
    public Course getByID(int courseId) {
        return courseRepository.getByID(courseId);
    }
    @Override
    public void update(int courseId, Course course) {
        courseRepository.update(courseId,course);
    }

    @Override
    public void delete(int courseId) {
        courseRepository.delete(courseId);
    }




}
