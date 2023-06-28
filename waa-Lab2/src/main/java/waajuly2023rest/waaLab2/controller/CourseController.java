package waajuly2023rest.waaLab2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import waajuly2023rest.waaLab2.model.Course;
import waajuly2023rest.waaLab2.service.impl.CourseServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseServiceImpl courseService;

    @PostMapping(value = {"/", "add"})
    public void createCourse(Course course) {
        courseService.createCourse(course);
    }

    @PutMapping("/{courseId}")
    public void updateCourse(@PathVariable int courseId, @RequestBody Course course) {
        courseService.updateCourse(course, courseId);
    }

    @DeleteMapping("{courseId}")
    public void deleteCourse(@PathVariable int courseId) {
        courseService.deleteCourse(courseId);
    }

    @GetMapping("/{courseId}")
    public Course getCourse(@PathVariable int courseId) {
        return courseService.getCourse(courseId);
    }

    @GetMapping("/{studentId}")
    public List<Course> getCoursesByStudentId(@PathVariable int studentId) {
        return courseService.getCoursesByStudentId(studentId);
    }

}
