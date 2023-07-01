package com.lab2.service;

import com.lab2.entity.Course;
import com.lab2.entity.Student;

import java.util.List;

public interface StudentService {
    void save(Student s);
    Student getById(int id);
    List<Student> getAll();
    void update(int id,Student student);
    void addCourseTakenByID(int id, Course course);
    void delete(int id);
    List<Student> getStudentsByMajor(String major);
    List<Course> getCoursesByStudentId(int studentId);


}
