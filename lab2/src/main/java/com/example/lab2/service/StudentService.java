package com.example.lab2.service;

import com.example.lab2.model.Course;
import com.example.lab2.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student saveStudent(Student student);
    Student updateStudent(Student student);
    void deleteStudent(Long id);





}
