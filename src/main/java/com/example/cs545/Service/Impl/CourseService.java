package com.example.cs545.Service.Impl;

import com.example.cs545.DAO.CourseRepo;
import com.example.cs545.Domain.Course;
import com.example.cs545.Service.CourseServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements CourseServiceInt {
    @Autowired
    CourseRepo courseRepo;

    @Override
    public List<Course> getAll() {
        return courseRepo.getAll();
    }

    @Override
    public void createCourse(Course course) {
        courseRepo.create(course);
    }

    @Override
    public void updateCourse(long id, Course course) {
        courseRepo.update(id,course);
    }

    @Override
    public void deleteCourse(long id) {
        courseRepo.delete(id);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepo.getCourseById(id);
    }
}
