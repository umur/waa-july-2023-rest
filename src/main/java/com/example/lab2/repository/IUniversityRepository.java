package com.example.lab2.repository;

import java.util.List;

public interface IUniversityRepository {

    void addCourse(Course course);

    boolean deleteCourse(Course course);

    List<Course> getAllCourse();

    List<Student> getAllStudent();

    void addStudent(Student student);

    void deleteStudent(Student student);
}
