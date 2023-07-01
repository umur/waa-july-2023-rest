package com.lab2.service.impl;

import com.lab2.entity.Course;
import com.lab2.repository.CourseRepository;
import com.lab2.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public void save(Course c) {
        courseRepository.save(c);

    }

    @Override
    public Course getByID(int id) {
        return courseRepository.getByID(id);
    }

    @Override
    public List<Course> getAll() {
        return courseRepository.getAll();
    }

    @Override
    public void update(int id, Course course) {
    courseRepository.update(id, course);
    }

    @Override
    public void delete(int id) {
    courseRepository.delete(id);
    }
}
