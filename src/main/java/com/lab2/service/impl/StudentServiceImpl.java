package com.lab2.service.impl;

import com.lab2.entity.Course;
import com.lab2.entity.Student;
import com.lab2.repository.StudentRepository;
import com.lab2.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    @Override
    public void save(Student s) {
    studentRepository.save(s);
    }

    @Override
    public Student getById(int id) {
        return studentRepository.getById(id);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    @Override
    public void update(int id, Student student) {
    studentRepository.update(id,student);
    }

    @Override
    public void addCourseTakenByID(int id, Course course) {
        studentRepository.addCourseTakenByID(id, course);
    }

    @Override
    public void delete(int id) {
    studentRepository.delete(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepository.getStudentsByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        return studentRepository.getCoursesByStudentId(studentId);
    }
}
