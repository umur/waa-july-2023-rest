package waa.restapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import waa.restapp.domain.Course;
import waa.restapp.domain.Student;
import waa.restapp.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student create(@RequestBody Student student){
        return studentService.create(student);
    }

    @GetMapping
    public List<Student> getAll(){
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Integer id){
        return studentService.findById(id);
    }

    @GetMapping("/major/{major}")
    public List<Student> getStudentsByMajor(@PathVariable String major){
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/courses/{id}")
    public List<Course> getCoursesByStudentId(@PathVariable Integer id){
        return studentService.getCoursesByStudentId(id);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Integer id, @RequestBody Student student){
        return studentService.update(id, student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        studentService.delete(id);
    }
}
