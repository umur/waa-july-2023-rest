package com.waa_lab2.backend.service;

import com.waa_lab2.backend.model.Course;
import com.waa_lab2.backend.model.Student;

import java.util.List;

public interface StudentService {
    void create(Student s);
    List<Student> getAll();
    Student getByID(int studentId);
    List<Student> getStudentsByMajor(String major);
    List<Course> getCoursesByStudentId(int studentId);
    void update(int studentId,Student student);
    void delete(int studentId);


}
