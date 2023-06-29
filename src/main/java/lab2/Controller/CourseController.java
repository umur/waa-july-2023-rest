package lab2.Controller;

import lab2.Model.Course;
import lab2.Model.Student;
import lab2.Service.CourseService;
import lab2.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAll(){
        return courseService.getAll();
    }

    @PostMapping
    public void create(@RequestBody Course course) {
        courseService.create(course);
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id){
        return courseService.getRecordById(id);
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
