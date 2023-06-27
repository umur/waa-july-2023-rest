package com.example.backend.service.impl;

import com.example.backend.entity.Course;
import com.example.backend.entity.Student;
import com.example.backend.repository.StudentRepository;
import com.example.backend.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public void create(Student student) {

        if (student.getEmail().equals("")) {
            throw new IllegalArgumentException("Email can not be empty");
        }
        if (student.getFirstName().length() < 2) {
            throw new IllegalArgumentException("First Name is too short");
        }
        if (student.getLastName().length() < 2) {
            throw new IllegalArgumentException("Last Name is too short");
        }
        if (!student.getEmail().contains("@")) {
            throw new IllegalArgumentException("Email must contain @");
        }
        boolean isCodeExists = studentRepository.getAll()
                .stream()
                .filter(c -> c.getEmail().equals(student.getEmail()))
                .findAny()
                .isPresent();
        if (!isCodeExists) {
            studentRepository.create(student);
        } else {
            throw new IllegalArgumentException("Student already in use");
        }

    }

    @Override
    public Student getById(Long id) {
        return studentRepository.getById(id);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepository.getStudentsByMajor(major);
    }

    @Override
    public void update(Student student) {
        if (student.getEmail().equals("")) {
            throw new IllegalArgumentException("Email can not be empty");
        }
        if (student.getFirstName().length() < 2) {
            throw new IllegalArgumentException("First Name is too short");
        }
        if (student.getLastName().length() < 2) {
            throw new IllegalArgumentException("Last Name is too short");
        }
        if (!student.getEmail().contains("@")) {
            throw new IllegalArgumentException("Email must contain @");
        }
        boolean isCodeExists = studentRepository.getAll().stream().filter(c -> c.getEmail().equals(student.getEmail())
                && c.getId() != student.getId()).findAny().isPresent();
        if (!isCodeExists) {
            studentRepository.update(student);
        } else {
            throw new IllegalArgumentException("Student already in use");
        }
    }

    @Override
    public void delete(Long id) {
        studentRepository.delete(id);
    }

    @Override
    public List<Course> getCoursesByStudentId(Long id) {
        Student student = getById(id);
        if (student != null) {
            return student.getCoursesTaken();
        }
        return new ArrayList<>();
    }
}
