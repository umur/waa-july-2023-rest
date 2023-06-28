package com.example.demo.service.impl;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepo;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    @Override
    public void create(Student student) {
        if(student.getFirstName() == null || student.getFirstName().length() < 5) {
            throw new RuntimeException("Student first name must be at least 5 characters");
        }
        if(student.getLastName() == null || student.getLastName().length() < 5) {
            throw new RuntimeException("Student last name must be at least 5 characters");
        }
        if(student.getEmail() == null || !student.getEmail().contains("@")) {
            throw new RuntimeException("Student must contain @");
        }
        if(student.getMajor() == null || student.getMajor().isEmpty()) {
            throw new RuntimeException("Student major is mandatory");
        }
        studentRepo.create(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public void update(Student student) {
        if(student.getFirstName() == null || student.getFirstName().length() < 5) {
            throw new RuntimeException("Student first name must be at least 5 characters");
        }
        if(student.getLastName() == null || student.getLastName().length() < 5) {
            throw new RuntimeException("Student last name must be at least 5 characters");
        }
        if(student.getEmail() == null || !student.getEmail().contains("@")) {
            throw new RuntimeException("Student must contain @");
        }
        if(student.getMajor() == null || student.getMajor().isEmpty()) {
            throw new RuntimeException("Student major is mandatory");
        }
        studentRepo.update(student);
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepo.getStudent(id);
    }

    @Override
    public void delete(Long id) {
        studentRepo.delete(id);
    }

    @Override
    public List<Course> getCoursesByStudentId(Long id) {
        return studentRepo.getCoursesByStudentId(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major);
    }
}
