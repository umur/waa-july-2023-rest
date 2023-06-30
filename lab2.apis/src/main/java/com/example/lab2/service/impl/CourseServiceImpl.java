package com.example.lab2.service.impl;

import com.example.lab2.entity.Course;
import com.example.lab2.repository.CourseRepo;
import com.example.lab2.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    final CourseRepo repo;

    @Override
    public void create(Course course) {
        if (course.getName().isEmpty())
            throw new RuntimeException("Name is required");

        if (course.getCode().length() != 4)
            throw new RuntimeException("Code must be 4 digits");

        repo.create(course);

    }

    @Override
    public void update(long id, Course course) {
        if (course.getName().isEmpty())
            throw new RuntimeException("Name is required");

        if (course.getCode().length() != 4)
            throw new RuntimeException("Code must be 4 digits");
        repo.update(id, course);
    }

    @Override
    public void delete(long id) {
        repo.delete(id);
    }

    @Override
    public Course getById(long id) {

        return repo.getById(id);
    }

    @Override
    public List<Course> getAll() {
        return repo.getAll();
    }
}
