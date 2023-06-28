package waa.restapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import waa.restapp.domain.Course;
import waa.restapp.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public void create(@RequestBody Course course){
        courseService.create(course);
    }

    @GetMapping
    public List<Course> getAll(){
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    public Course getOne(@PathVariable Integer id){
        return courseService.findOne(id);
    }

    @PutMapping("/{id}")
    public Course update(@PathVariable Integer id, @RequestBody Course course){
        return courseService.update(id, course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        courseService.delete(id);
    }
}
