package com.lab2.controller;

import com.lab2.entity.Course;
import com.lab2.entity.Student;
import com.lab2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public void save(@RequestBody Student s) {
        studentService.save(s);
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable int id) {
        return studentService.getById(id);
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Student student) {
        studentService.update(id, student);
    }

    @PutMapping("addCourseTakenByID/{id}")
    public void addCourseTakenByID(@PathVariable int id, @RequestBody Course course) {
        studentService.addCourseTakenByID(id, course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        studentService.delete(id);

    }

    @GetMapping("/getStudents/{major}")
    public List<Student> getStudentsByMajor(@PathVariable String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/getCourse/{studentId}")
    public List<Course> getCoursesByStudentId(@PathVariable int studentId) {
        return studentService.getCoursesByStudentId(studentId);
    }
}
