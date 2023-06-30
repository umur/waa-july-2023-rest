package com.waa_lab2.backend.service.impl;

import com.waa_lab2.backend.model.Course;
import com.waa_lab2.backend.model.Student;
import com.waa_lab2.backend.repository.StudentRepository;
import com.waa_lab2.backend.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor  // initializes final field variables....like studentRepository
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    @Override
    public void create(Student s) {
        studentRepository.save(s);
    }

    @Override
    public Student getByID(int studentId) {
        return studentRepository.getByID(studentId);
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
    public List<Course> getCoursesByStudentId(int studentId) {
        return studentRepository.getCoursesByStudentID(studentId);
    }
    @Override
    public void update(int studentId, Student student) {
        studentRepository.update(studentId,student);
    }

    @Override
    public void delete(int studentId) {
        studentRepository.delete(studentId);
    }

}
