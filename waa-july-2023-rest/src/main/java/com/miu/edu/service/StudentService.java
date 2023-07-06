package com.miu.edu.service;

import com.miu.edu.model.Course;
import com.miu.edu.model.Student;

import java.util.List;

public interface StudentService {
    public void create(Student student);

    public List<Student> getAll();

    public Student getById(Long id);

    public List<Student> getByMajor(String major);

    List<Course> getCoursesByStudentId(int studentId);

}
