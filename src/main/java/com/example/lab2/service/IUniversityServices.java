package com.example.lab2.service;

import com.example.lab2.repository.Course;
import com.example.lab2.repository.Student;

import java.util.List;

public interface IUniversityServices {

    List<Student> getAllStudentsByMajor(String major);
    Student getStudentCoursesByStudentId(int studentId) throws Exception ;

    void addCourse(Course course);


    void deleteCourse(Course course);

    List<Course> getAllCourse() ;

    List<Student> getAllStudent();

    void addStudent(Student student) ;

    void deleteStudent(Student student);
}
