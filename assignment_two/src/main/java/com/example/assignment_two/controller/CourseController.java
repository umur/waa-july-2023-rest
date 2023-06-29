package com.example.assignment_two.controller;

import com.example.assignment_two.entity.Course;
import com.example.assignment_two.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public List<Course> findAll(){
        return courseService.findAll();
    }

    @PostMapping
    public void create(@RequestBody Course course){
        courseService.create(course);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Course course){
        courseService.update(id, course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        courseService.delete(id);
    }
}
