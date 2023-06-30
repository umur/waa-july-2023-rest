package com.miu.waa.lab2.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miu.waa.lab2.entity.Course;
import com.miu.waa.lab2.repository.CourseRepo;
import com.miu.waa.lab2.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepo courseRepo;

    public Course create(Course course) {
        return courseRepo.create(course);
    }

    public Course update(Course course) {
        findById(course.getId());
        return courseRepo.update(course);
    }

    public Course delete(Long id) {
        findById(id);
        return courseRepo.delete(id);
    }

    public List<Course> findAll() {
        return courseRepo.findAll();
    }

    public Course findById(Long id) {
        if (id == null) {
            throw new RuntimeException("Course ID cannot be null.");
        }

        Optional<Course> optionalCourse = courseRepo.findById(id);

        if (!optionalCourse.isPresent()) {
            throw new RuntimeException("Course is not found.");
        }

        return optionalCourse.get();
    }
}
