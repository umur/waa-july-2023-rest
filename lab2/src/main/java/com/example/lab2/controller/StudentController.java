package com.example.lab2.controller;

import com.example.lab2.model.Student;
import com.example.lab2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = {"/",  "/home"})
    public String getStudent() {
        return "index";
    }
    @GetMapping("/all")
    public List<Student> getAllStudents() {
       // studentService.getAllStudents();
        return studentService.getAllStudents();
    }
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/save")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }
    @PutMapping("/update")
    public Student updateStudent( @RequestBody Student student) {
        return studentService.updateStudent(student);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteStudent(Long id) {
        studentService.deleteStudent(id);
    }
}
