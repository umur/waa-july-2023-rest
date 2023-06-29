package com.waa.lab2.controller;
import com.waa.lab2.entity.Student;
import com.waa.lab2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/url1")
    public RedirectView getHtmlFile(){
        return new RedirectView("students.html");
    }

    @GetMapping("/studentsMajor/{major}")
    public List<Student> getStudentsByMajor(@PathVariable String major){
        return studentService.getStudentByMajor(major);
    }
    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }
    @PostMapping("/students")
    public String addStudentWithCourses(@RequestBody Student student){
     studentService.addStudent(student);
        return "student added";
    }
    @PutMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @RequestBody Student student){
        return studentService.updateStudent(id,student);
    }
    @DeleteMapping("students/{id}")
    public String deleteStudent(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }
}
