package com.waa.demo.repositories.impls;

import com.waa.demo.entities.Course;
import com.waa.demo.entities.Student;
import com.waa.demo.repositories.StudentRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class StudentRepoImpl implements  StudentRepo{

    public static Long lastStudentId=0L;
    public static Long lastCourseId=0L;
    public static List<Student> students = new ArrayList<>();


    @Override
    public void add(Student student) {
        student.setId(++lastStudentId);
        student.setCoursesTaken(student.getCoursesTaken().stream().peek(x->{
            if(x.getId()==null) x.setId(++lastCourseId);
        }).collect(Collectors.toList()));
        students.add(student);

    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public Student getById(Long id) {
        return students.stream().filter(x->x.getId()==id).findFirst().orElseThrow(()->new RuntimeException("Couldn't find Student with Id "+id));
    }

    @Override
    public void save(Long id, Student student) {
        student.setId(id);
        students=students.stream().map(x->x.getId()==id?student:x).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        students=students.stream().filter(x->x.getId()!=id).collect(Collectors.toList());

    }

    @Override
    public List<Student> findAllByMajor(String major) {
        return students.stream().filter(x-> x.getMajor().equals(major)).collect(Collectors.toList());
    }

    @Override
    public List<Course> getCoursesByStudentId(Long id) {
        return      students.stream().filter(x->x.getId()==id).findFirst().map(Student::getCoursesTaken).orElseThrow(()->new RuntimeException("student not found"));

    }
}
