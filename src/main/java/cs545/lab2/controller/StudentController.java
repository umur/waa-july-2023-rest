package cs545.lab2.controller;

import cs545.lab2.entity.Course;
import cs545.lab2.entity.Student;
import cs545.lab2.service.StudentService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/studentsviews")
    public RedirectView getStudentHtml() {
        return new RedirectView("studentView.html");
    }

@PostMapping("/students")
    public Student addStudent( @RequestBody Student student){
     studentService.addStudent(student);
     return student;

}
@GetMapping("/students")
    public List<Student> getAlStudents(){
    return studentService.getAllStudents();
}
@GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id){
    return studentService.getStudentById(id);
}
@GetMapping("/studentsmajor/{major}")
    public List<Student> getStudentByMajor(@PathVariable String major){
    return studentService.getStudentsByMajor(major);

}
}
