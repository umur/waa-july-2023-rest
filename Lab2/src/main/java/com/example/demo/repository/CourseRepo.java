package com.example.demo.repository;

import com.example.demo.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CourseRepo {
    static List<Course> courses = new ArrayList<>();

    public void create(Course course) {
        courses.add(course);
    }

    public void update(Course course) {
        courses = courses.stream()
                .map(c -> c.getId().equals(course.getId()) ? course : c)
                .collect(Collectors.toList());
    }

    public List<Course> findAll() {
        return courses;
    }

    public Course getCourse(Long id) {
        return courses.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void delete(Long id) {
        courses.removeIf(c -> c.getId().equals(id));
    }
}
