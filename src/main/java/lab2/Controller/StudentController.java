package lab2.Controller;

import lab2.Model.Student;
import lab2.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public void create(@RequestBody Student student) {
        studentService.create(student);
    }

    @GetMapping
    public List<Student> getAll(){
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student getUserById(@PathVariable Long id){
        return studentService.getRecordById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Student student){
        studentService.update(id, student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        studentService.delete(id);
    }

}
