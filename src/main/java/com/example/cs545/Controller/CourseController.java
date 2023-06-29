package com.example.cs545.Controller;

import com.example.cs545.Domain.Course;
import com.example.cs545.Service.Impl.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping
    public void createCourse(@RequestBody Course course){
        System.out.println(course.toString());
        courseService.createCourse(course);

    }

    @GetMapping
    public List<Course> getAllCourse(){
        return courseService.getAll();
    }
    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id){

        return courseService.getCourseById(id);
    }
    @DeleteMapping("/{courseId}")
    public void delete(@PathVariable Long courseId){

       courseService.deleteCourse(courseId);
    }
}
