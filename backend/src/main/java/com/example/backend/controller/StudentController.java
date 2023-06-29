package com.example.backend.controller;

import com.example.backend.entity.Course;
import com.example.backend.entity.Student;
import com.example.backend.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.ok(studentService.getAll());
    }
    @GetMapping("/getStudentsByMajor")
    public List<Student> getStudentsByMajor(@RequestParam(required = true,name = "major") String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{id}/courses")
    public List<Course> getCoursesByStudentId(@PathVariable Long id) {
        return studentService.getCoursesByStudentId(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        Student student = studentService.getById(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }


    @PostMapping
    public ResponseEntity<?> add(@RequestBody Student student) {
        studentService.create(student);
        return ResponseEntity.created(URI.create("/students/" + student.getId())).build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Student student) {
        if (id != student.getId()) {
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Id dose not match Student Id"
            );
        }
        studentService.update(student);
        return ResponseEntity.created(URI.create("/students/" + student.getId())).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
