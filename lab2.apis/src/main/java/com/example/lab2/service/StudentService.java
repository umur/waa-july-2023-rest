package com.example.lab2.service;

import com.example.lab2.entity.Course;
import com.example.lab2.entity.Student;

import java.util.List;

public interface StudentService {
    public void create(Student student);

    public void update(long id, Student student);

    public void delete(long id);

    public Student getById(long id);

    public List<Student> getAll();

    public List<Student> getByMajor(String major);


    public List<Course> getCoursesByStudentId(long id);
}
