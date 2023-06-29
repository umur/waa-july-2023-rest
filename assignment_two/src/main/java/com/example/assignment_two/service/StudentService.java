package com.example.assignment_two.service;

import com.example.assignment_two.entity.Course;
import com.example.assignment_two.entity.Student;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    void create(Student student);

    void update(Long id, Student student);

    void delete(Long id);

    List<Student> getStudentsByMajor(String major);

    List<Course> getCoursesByStudentId(@PathVariable Long id);
}
