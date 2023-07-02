package com.example.lab2.controller;

import com.example.lab2.repository.Student;
import com.example.lab2.service.IUniversityServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {

    final IUniversityServices universityServices;


    @GetMapping
    public List<Student> getAllStudent() {
        return universityServices.getAllStudent();
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        universityServices.addStudent(student);
    }

    @DeleteMapping
    public void deleteStudent(@RequestBody Student student) {
        universityServices.deleteStudent(student);
    }

    @GetMapping("/filterByMajor")
    public List<Student> getStudentsByMajor(@RequestBody String major) {
        return universityServices.getAllStudentsByMajor(major);
    }

    @GetMapping("{studentId}")
    public Student getCoursesByStudentId(@PathVariable int studentId) throws Exception {
        return universityServices.getStudentCoursesByStudentId(studentId);
    }

}
