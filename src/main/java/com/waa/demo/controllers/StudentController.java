package com.waa.demo.controllers;

import com.waa.demo.entities.Course;
import com.waa.demo.entities.Student;
import com.waa.demo.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/students")
@CrossOrigin(origins = "*")
public class StudentController {
    private final StudentService service;
    @PostMapping
    public void create(@RequestBody Student student){
        service.create(student);
    }

    @GetMapping
    public List<Student> getAll(
            @RequestParam(required = false,defaultValue = "") String major
    ){
        if(!major.equals("")) return service.filterByMajor(major);
        return service.findAll();
    }


    @GetMapping("/{id}")
public Student getById(@PathVariable Long id){

        return service.getById(id);
    }

    @GetMapping("/{id}/courses")
    public List<Course> getCoursesByStudentId(@PathVariable Long id){

        return service.getCoursesByStudentId(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id,@RequestBody Student student){
            service.update(id,student);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }








}
