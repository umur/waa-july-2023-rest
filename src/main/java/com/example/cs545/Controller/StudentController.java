package com.example.cs545.Controller;

import com.example.cs545.Domain.Course;
import com.example.cs545.Domain.Student;
import com.example.cs545.Service.Impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public void createStudent(@RequestBody Student student){
        studentService.createStudent(student);

    }

    @GetMapping
    public List<Student> getAllStudents(){
       return studentService.getAll();
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Long id){

        return studentService.getStudentById(id);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable Long id,@RequestBody Student student){

        studentService.updateStudent(id, student);
    }
    @DeleteMapping("/{studentId}")
    public void delete(@PathVariable Long studentId){

        studentService.deleteStudent(studentId);
    }

    @GetMapping("/{major}")
    public List<Student> getStudentsByMajor(@PathVariable String major){
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{studentId}")
    public List<Course> getCoursesByStudentId(@PathVariable Long studentId){
        return studentService.getCoursesByStudentId(studentId);
    }
}
