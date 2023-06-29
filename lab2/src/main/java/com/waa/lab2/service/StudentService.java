package com.waa.lab2.service;

import com.waa.lab2.entity.Course;
import com.waa.lab2.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> getStudentByMajor(String major);
    Student getStudentById(Long id);
    List<Student> getStudents();
    List<Course> getCoursesByStudentId(Long studentId);
    String addStudent(Student student);
    String updateStudent(Long id, Student student);
    String deleteStudent(Long id);


}
