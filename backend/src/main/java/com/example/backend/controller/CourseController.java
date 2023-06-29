package com.example.backend.controller;

import com.example.backend.entity.Course;
import com.example.backend.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/courses")
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<List<Course>> getAll() {
        return ResponseEntity.ok(courseService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        Course course = courseService.getById(id);
        if (course == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(course);
    }


    @PostMapping
    public ResponseEntity<?> add(@RequestBody Course course) {
        courseService.create(course);
        return ResponseEntity.created(URI.create("/courses/" + course.getId())).build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Course course) {
        if (id != course.getId()) {
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Id dose not match Course Id"
            );
        }
        courseService.update(course);
        return ResponseEntity.created(URI.create("/courses/" + course.getId())).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        courseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
