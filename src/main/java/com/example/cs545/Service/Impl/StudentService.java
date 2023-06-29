package com.example.cs545.Service.Impl;

import com.example.cs545.DAO.StudentRepo;
import com.example.cs545.Domain.Course;
import com.example.cs545.Domain.Student;
import com.example.cs545.Service.StudentServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements StudentServiceInt {
    @Autowired
    StudentRepo studentRepo;

    @Override
    public List<Student> getAll() {
        return studentRepo.getAll();
    }

    @Override
    public void createStudent(Student student) {
        studentRepo.create(student);

    }

    @Override
    public void updateStudent(long id, Student student) {
        studentRepo.update(id,student);

    }

    @Override
    public void deleteStudent(long id) {
        studentRepo.delete(id);

    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepo.getStudentById(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(Long studentId) {
       Student student= studentRepo.getStudentById(studentId);
       return student.getCoursesTaken();
    }
}
