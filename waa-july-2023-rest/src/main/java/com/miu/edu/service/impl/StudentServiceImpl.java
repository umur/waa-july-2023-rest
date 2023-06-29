package com.miu.edu.service.impl;

import com.miu.edu.model.Course;
import com.miu.edu.model.Student;
import com.miu.edu.repository.StudentRepository;
import com.miu.edu.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;
    @Override
    public void create(Student student) {
        repository.create(student);
    }

    @Override
    public List<Student> getAll() {
        return repository.findAll();
    }

    @Override
    public Student getById(Long id) {
        return repository.findById(id);
    }

    public List<Student> getByMajor(String major){
        return repository.findByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        return repository.getCoursesByStudentId(studentId);
    }
}
