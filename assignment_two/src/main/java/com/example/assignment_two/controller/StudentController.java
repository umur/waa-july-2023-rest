package com.example.assignment_two.controller;

import com.example.assignment_two.entity.Course;
import com.example.assignment_two.entity.Student;
import com.example.assignment_two.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @GetMapping("/filterByMajor")
    public List<Student> getStudentsByMajor(@RequestParam String major){
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{id}/courses")
    public List<Course> getCoursesByStudentId(@PathVariable Long id){
        return studentService.getCoursesByStudentId(id);
    }

    @PostMapping
    public void create(@RequestBody Student student){
        studentService.create(student);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Student student){
        studentService.update(id, student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        studentService.delete(id);
    }
}
