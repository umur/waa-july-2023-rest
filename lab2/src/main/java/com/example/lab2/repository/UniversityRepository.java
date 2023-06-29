package com.example.lab2.repository;

import com.example.lab2.entity.Course;
import com.example.lab2.entity.Student;

import java.util.List;

public interface UniversityRepository {
    public List<Student> findAllStudents();
    void createStudent(Student student);

    Student updateStudent(int studentId, Student student);

    void deleteStudent(int studentId);

    Student findStudentById(int studentId);
}
