package com.example.lab2.service.impl;

import com.example.lab2.model.Student;
import com.example.lab2.repository.StudentRepository;
import com.example.lab2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.getReferenceById(id);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        Student student1 = studentRepository.getReferenceById(student.getId());
        student1.setId(student.getId());
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setEmail(student.getEmail());
        student1.setMajor(student.getMajor());
        student1.setCoursesTaken(student.getCoursesTaken());
        return studentRepository.save(student1);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);

    }
}
