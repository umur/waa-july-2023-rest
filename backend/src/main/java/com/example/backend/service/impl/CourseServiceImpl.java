package com.example.backend.service.impl;

import com.example.backend.entity.Course;
import com.example.backend.repository.CourseRepository;
import com.example.backend.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public void create(Course course) {
        if (course.getName().isEmpty()) {
            throw new IllegalArgumentException("Course name can't be empty");
        }
        if (course.getCode().isEmpty()) {
            throw new IllegalArgumentException("Course code can't be empty");
        }
        boolean isCodeExists = courseRepository
                .getAll()
                .stream()
                .filter(c -> c.getCode().equalsIgnoreCase(course.getCode()))
                .findAny()
                .isPresent();
        if (!isCodeExists) {
            courseRepository.create(course);
        } else {
            throw new IllegalArgumentException("Course code already in use");
        }
    }

    @Override
    public Course getById(Long id) {
        return courseRepository.getById(id);
    }

    @Override
    public List<Course> getAll() {
        return courseRepository.getAll();
    }

    @Override
    public void update(Course course) {
        courseRepository.update(course);

        if (course.getName().isEmpty()) {
            throw new IllegalArgumentException("Course name can't be empty");
        }
        if (course.getCode().isEmpty()) {
            throw new IllegalArgumentException("Course code can't be empty");
        }
        boolean isCodeExists = courseRepository
                .getAll()
                .stream()
                .filter(c -> c.getCode().equalsIgnoreCase(course.getCode())
                        && c.getId() != course.getId())
                .findAny()
                .isPresent();
        if (!isCodeExists) {
            courseRepository.update(course);
        } else {
            throw new IllegalArgumentException("Course code already in use");
        }
    }

    @Override
    public void delete(Long id) {
        courseRepository.delete(id);
    }
}
