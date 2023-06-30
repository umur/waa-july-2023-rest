package com.example.WAALab2.service;

import com.example.WAALab2.entity.Course;
import com.example.WAALab2.entity.Student;

import java.util.List;

public interface StudentService {
    Student create(Student student);

    List<Student> get();

    Student get(Long id);

    Student update(Long id, Student student);

    Student delete(Long id);

    List<Student> getStudentsByMajor(String major);

    List<Course> getCoursesByStudentId(Long studentId);
}
