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
    public Course create(@RequestBody Course course){
        return courseService.create(course);
    }

    @GetMapping
    public List<Course> getAll(){
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable Integer id){
        return courseService.findById(id);
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
