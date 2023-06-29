package com.example.cs545.Service;

import com.example.cs545.Domain.Course;
import com.example.cs545.Domain.Student;

import java.util.List;

public interface StudentServiceInt {
    List<Student> getAll();
    void createStudent(Student student);
    void updateStudent(long id, Student student);
    void deleteStudent(long id);
    Student getStudentById(Long id);
    List<Student> getStudentsByMajor(String major);
    List<Course> getCoursesByStudentId(Long studentId);
}
