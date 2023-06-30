package com.example.WAALab2.service.impl;

import com.example.WAALab2.entity.Course;
import com.example.WAALab2.entity.Student;
import com.example.WAALab2.repository.StudentRepo;
import com.example.WAALab2.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    @Override
    public Student create(Student student){

        if(!student.getEmail().contains("@"))
            throw new RuntimeException("Invalid Email Address");

        if(student.getFirstName().isBlank() || student.getLastName().isBlank())
            throw new RuntimeException("Name Cannot Be Blank");

        return studentRepo.create(student);
    }

    @Override
    public List<Student> get(){
        return studentRepo.get();
    }

    @Override
    public Student get(Long id){
        return studentRepo.get(id);
    }

    @Override
    public Student update(Long id, Student student){
        if(!student.getEmail().contains("@"))
            throw new RuntimeException("Invalid Email Address");

        if(student.getFirstName().isBlank() || student.getLastName().isBlank())
            throw new RuntimeException("Name Cannot Be Blank");

        student.setId(id);
        return studentRepo.update(student);
    }

    @Override
    public Student delete(Long id){
        return studentRepo.delete(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major){
        return studentRepo.getStudentsByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(Long studentId){
        return studentRepo.getCoursesByStudentId(studentId);
    }
}
