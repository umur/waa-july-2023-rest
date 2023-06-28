package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;

import java.util.List;

public interface StudentService {

    void create(Student student);

    List<Student> findAll();

    void update(Student student);

    Student getStudent(Long id);

    void delete(Long id);
    List<Course> getCoursesByStudentId(Long id);

    List<Student> getStudentsByMajor(String major);
}
