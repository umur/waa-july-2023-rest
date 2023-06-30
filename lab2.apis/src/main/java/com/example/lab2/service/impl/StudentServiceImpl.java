package com.example.lab2.service.impl;

import com.example.lab2.entity.Course;
import com.example.lab2.entity.Student;
import com.example.lab2.repository.StudentRepo;
import com.example.lab2.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    final StudentRepo repo;

    @Override
    public void create(Student student) {
//        if (student.getName().isEmpty())
//            throw new RuntimeException("Name is required");


        repo.create(student);

    }

    @Override
    public void update(long id, Student student) {
//        if (student.getName().isEmpty())
//            throw new RuntimeException("Name is required");

        repo.update(id, student);
    }

    @Override
    public void delete(long id) {
        repo.delete(id);
    }

    @Override
    public Student getById(long id) {

        return repo.getById(id);
    }

    @Override
    public List<Student> getAll() {
        return repo.getAll();
    }

    @Override
    public List<Student> getByMajor(String major) {
        return  repo.getByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(long id) {
        return  repo.getCoursesByStudentId( id);
    }
}
