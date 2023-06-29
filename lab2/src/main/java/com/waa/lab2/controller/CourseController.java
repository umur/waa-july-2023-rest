package com.waa.lab2.controller;
import com.waa.lab2.entity.Course;
import com.waa.lab2.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;
    @GetMapping("/urls")
    public RedirectView getHtmlFile(){
        return new RedirectView("CourseView.html");
    }
    @GetMapping("/courses")
    public List<Course> getCourses(){
        return courseService.getAllCourses();
    }
    @GetMapping("/coursesByStudentId/{id}")
    public List<Course>getCourseByStdId(@PathVariable Long id){
        return courseService.getCourseByStudentId(id);
    }
    @PostMapping("/courses")
    public String addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }
    @DeleteMapping("/courses/{id}")
    public String deleteCourse(@PathVariable Long id){
        return courseService.deleteCourse(id);
    }
    @PutMapping("/courses/{id}")
    public String updateCourse(Long id,Course course){
        return courseService.updateCourse(id, course);
    }
}
