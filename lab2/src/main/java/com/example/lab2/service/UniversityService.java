package com.example.lab2.service;

import com.example.lab2.entity.Course;
import com.example.lab2.entity.Student;

import java.util.List;

public interface UniversityService {

    void createStudent(Student student);

    Student updateStudent(int studentId, Student student);

    void deleteStudent(int studentId);

    Student findStudentById(int studentId);

    List<Student> getStudentsByMajor(String major);

    List<Course> getCoursesByStudentId(int studentId);

    public List<Student> findAllStudents();
}
