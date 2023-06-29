package com.example.demo.service.impl;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    public void updateStudent(Student student) {
        studentRepository.updateStudent(student);
    }

    public void deleteStudent(int studentId) {
        studentRepository.deleteStudent(studentId);
    }

    public Student getStudentById(int studentId) {
        return studentRepository.getStudentById(studentId);
    }

    public List<Student> getStudentsByMajor(String major) {
        return studentRepository.getStudentsByMajor(major);
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        return studentRepository.getCoursesByStudentId(studentId);
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

}
