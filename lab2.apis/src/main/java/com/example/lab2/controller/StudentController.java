package com.example.lab2.controller;

import com.example.lab2.entity.Course;
import com.example.lab2.entity.Student;
import com.example.lab2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
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
        var result = studentService.getAll();
        return result;
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {

        return studentService.getById(id);
    }
    @GetMapping("/filterByMajor")
    public List<Student> getAll(@RequestParam String major) {
        return  studentService.getByMajor(major);
    }


    @GetMapping("/filterCoursesByStudentId/{id}")
    public List<Course> filterCoursesByStudentId(@PathVariable long id) {
        return  studentService.getCoursesByStudentId(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Student student) {
        studentService.update(id, student);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }

}
