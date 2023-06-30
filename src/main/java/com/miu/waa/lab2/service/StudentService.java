package com.miu.waa.lab2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.miu.waa.lab2.entity.Student;

@Service
public interface StudentService {

    public Student create(Student student);

    public Student update(Student student);

    public Student delete(Long id);

    public Student findById(Long id);

    public List<Student> findAll();

    List<Student> getStudentsByMajor(String major);

}
