package com.miu.edu.controller;

import com.miu.edu.model.Course;
import com.miu.edu.model.Student;
import com.miu.edu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public void add(@RequestBody Student student) {
        service.create(student);
    }

    @GetMapping()
    public List<Student> getAll(){
        return service.getAll();
    }


    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id){

        return service.getById(id);
    }

    @GetMapping("/{major}")
    public List<Student> getByMajor(@PathVariable String major){

        return service.getByMajor(major);
    }


    @GetMapping("/getCourse/{studentId}")
    public List<Course> getCoursesByStudentId(@PathVariable int studentId) {
        return service.getCoursesByStudentId(studentId);
    }

}
