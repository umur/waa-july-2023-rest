package com.miu.edu.service.impl;

import com.miu.edu.model.Course;
import com.miu.edu.repository.CourseRepository;
import com.miu.edu.repository.StudentRepository;
import com.miu.edu.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;

    private final StudentRepository studentRepository;
    @Override
    public void create(Course course) {
   repository.create(course);
    }

    @Override
    public List<Course> getAll() {
       return repository.findAll();
    }

    @Override
    public Course getById(Long id) {
        return repository.findById(id);
    }


}
