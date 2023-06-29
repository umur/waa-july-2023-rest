package cs545.lab2.controller;

import cs545.lab2.entity.Course;
import cs545.lab2.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/coursesviews")
    public RedirectView getCourseHtml()
    {
        return new RedirectView("courseView.html");
    }
@PostMapping("/courses")
    public Course addCourses(@RequestBody Course course){
    courseService.addCourse(course);
    return course;
}
@GetMapping("/coursesget")
    public List<Course> getAllCourses(Course course){
    return courseService.getAllCourses(course);
}
@GetMapping("/courses/{id}")
    public Course getCourseById(long id){

    return courseService.getCourseById(id);
}
@GetMapping("/coursesstudent/{studentId}")
public List<Course> getCourseByStudent(@PathVariable Integer studentId){
    return courseService.getCoursesByStudentId(studentId);
}
@DeleteMapping("/courses/{id}")
    public void deleteById(@PathVariable Long id){

    courseService.deleteCourseById(id);
}
//@PutMapping("/course/{id}")
//    public void update(@PathVariable Long id,@RequestBody Course course){
//    courseService.updateCourse(id,course);
//}

}
