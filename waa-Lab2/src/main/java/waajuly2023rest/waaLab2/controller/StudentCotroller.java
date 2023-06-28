package waajuly2023rest.waaLab2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import waajuly2023rest.waaLab2.model.Student;
import waajuly2023rest.waaLab2.service.impl.StudentServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentCotroller {

    @Autowired
    private StudentServiceImpl studentService;

    @PostMapping(value = {"/","add"})
    public void create(Student student){
        studentService.create(student);
    }
    @PutMapping("/{studentId}")
    public void updateStudent(@PathVariable int studentId, @RequestBody Student student){
       studentService.update(student,studentId);
    }
    @DeleteMapping("{studentId}")
    public void deleteStudent(@PathVariable int studentId){
        studentService.delete(studentId);
    }
    @GetMapping("/{studentId}")
    public List<Student> getStudentsByMajor(String major) {
      List <Student> studentsByMajor = studentService.getStudentsByMajor(major);
        return studentsByMajor;
    }

    @GetMapping(value = "/list")
    public String displayHomePage(){
        return "home";
    }


}
