package com.waa.demo.services;

import com.waa.demo.entities.Course;
import com.waa.demo.entities.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    void create(Student student);

    List<Student> findAll();

    Student getById(Long id);

    void update(Long id, Student student);

    void delete(Long id);

    List<Student> filterByMajor(String major);

    List<Course> getCoursesByStudentId(Long id);
}
