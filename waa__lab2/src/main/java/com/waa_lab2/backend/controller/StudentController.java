package com.waa_lab2.backend.controller;

import com.waa_lab2.backend.model.Course;
import com.waa_lab2.backend.model.Student;
import com.waa_lab2.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@ResponseBody
@RequestMapping("/students")
public class StudentController {

    // initializing studentService
    private StudentService studentService;
    @Autowired   //  note.......from Spring 4.3, the @Autowired annotation is optional for constructor injection if the class has a single constructor
    StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    // handling post request
    @PostMapping
    public void createStudent(@RequestBody Student student){
        studentService.create(student);
    }

    // handling get request
    @GetMapping
    public List<Student> getAllStudent(){
       return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student getStudentByID(@PathVariable int id){
        return studentService.getByID(id);
    }

    @GetMapping("/getStudents/{major}")
    public List<Student> getStudentsByMajor(@PathVariable String major){
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/getCourses/{studentID}")
    public List<Course> getCoursesByStudentId(@PathVariable int studentID) {
        return studentService.getCoursesByStudentId(studentID);
    }

    // handling put request
    @PutMapping ("/{id}")
    public void updateStudent(@PathVariable int id, @RequestBody Student student){
        studentService.update(id,student);
    }

    // handling delete request
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id){
        studentService.delete(id);
    }
}
