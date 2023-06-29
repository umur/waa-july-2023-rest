package com.example.lab2.service;

import com.example.lab2.entity.Course;
import com.example.lab2.entity.Student;
import com.example.lab2.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UniversityServiceImpl implements UniversityService {
    @Autowired
    private UniversityRepository repository;

    @Override
    public void createStudent(Student student) {
        repository.createStudent(student);
    }

    @Override
    public Student updateStudent(int studentId, Student student) {
        return repository.updateStudent(studentId, student);
    }

    @Override
    public void deleteStudent(int studentId) {
        repository.deleteStudent(studentId);
    }

    @Override
    public Student findStudentById(int studentId) {
        return repository.findStudentById(studentId);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return Optional.of(repository.findAllStudents().stream().filter(s -> s.getMajor().equals(major)).collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        return Optional.of(repository.findStudentById(studentId).getCoursesTaken()).orElse(Collections.emptyList());
    }

    @Override
    public List<Student> findAllStudents() {
        return repository.findAllStudents();
    }
}
