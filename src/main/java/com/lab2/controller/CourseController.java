package com.lab2.controller;

import com.lab2.entity.Course;
import com.lab2.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@ResponseBody
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @PostMapping
    public void  save(@RequestBody Course c){
        courseService.save(c);
    }
    @GetMapping("/{id}")
    public Course getByID(@PathVariable int id){
        return courseService.getByID(id);
    }
    @GetMapping
    public List<Course> getAll(){
        return courseService.getAll();
    }
    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Course c){
        courseService.update(id,c);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        courseService.delete(id);
    }

}
