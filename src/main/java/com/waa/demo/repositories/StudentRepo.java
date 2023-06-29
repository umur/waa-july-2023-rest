package com.waa.demo.repositories;

import com.waa.demo.entities.Course;
import com.waa.demo.entities.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StudentRepo {
    void add(Student student);

    List<Student> findAll();

    Student getById(Long id);

    void save(Long id, Student student);

    void delete(Long id);

    List<Student> findAllByMajor(String major);

    List<Course> getCoursesByStudentId(Long id);
}
