package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public void create(@RequestBody Student student) {
        studentService.create(student);
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.findAll();
    }

    @GetMapping("/filterStudentsByMajor")
    public List<Student> getStudentsByMajor(@RequestParam String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/getCoursesByStudentId")
    public List<Course> getCoursesByStudentId(@RequestParam Long id) {
        return studentService.getCoursesByStudentId(id);
    }

    @GetMapping("/getAllCoursesOfStudent")
    public List<Course> getAllCoursesOfStudent(@RequestParam Long id) {
        return studentService.getCoursesByStudentId(id);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudent(id);
    }

    @PutMapping
    public void update(@RequestBody Student student) {
        studentService.update(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }
}
