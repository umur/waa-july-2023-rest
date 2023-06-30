package com.miu.waa.lab2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miu.waa.lab2.entity.Course;
import com.miu.waa.lab2.entity.Student;
import com.miu.waa.lab2.service.StudentService;

@RestController
@RequestMapping("/students/")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping
    public Student create(@RequestBody Student student) {
        return studentService.create(student);
    }

    @GetMapping
    public List<Student> findAll(String major) {
        if (major != null) {
            return studentService.getStudentsByMajor(major);
        }

        return studentService.findAll();
    }

    @PutMapping("{id}")
    public Student update(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        return studentService.update(student);
    }

    @DeleteMapping("{id}")
    public Student delete(@PathVariable Long id) {
        return studentService.delete(id);
    }

    @GetMapping("{id}")
    public Student findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @GetMapping("{id}/courses/")
    public List<Course> getCoursesByStudentId(@PathVariable Long id) {
        Student student = studentService.findById(id);
        return student.getCoursesTaken();
    }
}
