package com.example.assignment_two.service.impl;

import com.example.assignment_two.entity.Course;
import com.example.assignment_two.entity.Student;
import com.example.assignment_two.repository.StudentRepo;
import com.example.assignment_two.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;

    @Override
    public List<Student> findAll(){
        return studentRepo.findAll();
    }

    @Override
    public void create(Student student){
        studentRepo.create(student);
    }

    @Override
    public void update(Long id, Student student){
        studentRepo.update(id, student);
    }

    @Override
    public void delete(Long id){
        studentRepo.delete(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major){
        return studentRepo.getStudentsByMajor(major);
    }
    @Override
    public List<Course> getCoursesByStudentId(@PathVariable Long id){
        return studentRepo.getCoursesByStudentId(id);
    }
}
