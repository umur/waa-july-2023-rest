package com.example.WAALab2.controller;

import com.example.WAALab2.entity.Course;
import com.example.WAALab2.entity.Student;
import com.example.WAALab2.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public Student create(@RequestBody Student student){
        return studentService.create(student);
    }

    @GetMapping
    public List<Student> getAll(){
        return studentService.get();
    }

    @GetMapping("{id}")
    public  Student get(@PathVariable Long id)
    {
        return studentService.get(id);
    }

    @PutMapping("{id}")
    public Student update(@PathVariable Long id, @RequestBody Student student)
    {
        return studentService.update(id, student);
    }

    @DeleteMapping("{id}")
    public Student delete(@PathVariable Long id) {
        return studentService.delete(id);
    }

    @GetMapping("{id}/courses")
    public List<Course> getCoursesByStudentId(Long id){
        return studentService.getCoursesByStudentId(id);
    }

    @GetMapping("filter")
    public  List<Student> getStudentsByMajor(@RequestParam String major) {
        return studentService.getStudentsByMajor(major);
    }

}
