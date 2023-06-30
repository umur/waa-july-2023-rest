package com.miu.waa.lab2.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miu.waa.lab2.entity.Student;
import com.miu.waa.lab2.repository.StudentRepo;
import com.miu.waa.lab2.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo studentRepo;

    public Student create(Student student) {
        return studentRepo.create(student);
    }

    public Student update(Student student) {
        findById(student.getId());
        return studentRepo.update(student);
    }

    public Student delete(Long id) {
        findById(id);
        return studentRepo.delete(id);
    }

    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    public Student findById(Long id) {
        if (id == null) {
            throw new RuntimeException("Student ID cannot be null.");
        }

        Optional<Student> optionalStudent = studentRepo.findById(id);

        if (!optionalStudent.isPresent()) {
            throw new RuntimeException("Student is not found.");
        }

        return optionalStudent.get();
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major);
    }
}
