package com.example.backend.service;

import com.example.backend.entity.Course;
import com.example.backend.entity.Student;

import java.util.Iterator;
import java.util.List;

public interface StudentService {

    void create(Student student);
    Student getById(Long id);

    List<Student> getAll();

    List<Student> getStudentsByMajor(String major);

    void update(Student student);

    void delete(Long id);

    List<Course> getCoursesByStudentId(Long id);
}
