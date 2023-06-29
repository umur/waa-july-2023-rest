package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;

import java.util.List;

public interface StudentService {

    public void addStudent(Student student);
    public void updateStudent(Student student);
    public void deleteStudent(int studentId);
    public Student getStudentById(int studentId);
    public List<Student> getStudentsByMajor(String major);
    public List<Course> getCoursesByStudentId(int studentId);
    public List<Student> getAllStudents();


}
