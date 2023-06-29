package com.example.assignment_two.service.impl;

import com.example.assignment_two.entity.Course;
import com.example.assignment_two.repository.CourseRepo;
import com.example.assignment_two.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;

    @Override
    public List<Course> findAll(){
        return courseRepo.findAll();
    }

    @Override
    public void create(Course course){
        courseRepo.create(course);
    }

    @Override
    public void update(Long id,Course course){
        courseRepo.update(id, course);
    }

    @Override
    public void delete(Long id){
        courseRepo.delete(id);
    }
}
