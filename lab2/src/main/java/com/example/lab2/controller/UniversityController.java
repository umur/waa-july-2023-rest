package com.example.lab2.controller;

import com.example.lab2.entity.Course;
import com.example.lab2.entity.Student;
import com.example.lab2.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    @GetMapping
    public ResponseEntity<List<Student>> getAll(@RequestParam(value = "major", required = false) String major) {
        return ResponseEntity.ok(ObjectUtils.isEmpty(major) ? universityService.findAllStudents() : universityService.getStudentsByMajor(major));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(universityService.findStudentById(id));
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<List<Course>> getCoursesByStudent(@PathVariable Integer id) {
        return ResponseEntity.ok(universityService.getCoursesByStudentId(id));
    }

    @PostMapping
    public void create(@RequestBody Student student) {
        universityService.createStudent(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Integer id, @RequestBody Student student) {
        return ResponseEntity.ok(universityService.updateStudent(id, student));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        universityService.deleteStudent(id);
    }

}
