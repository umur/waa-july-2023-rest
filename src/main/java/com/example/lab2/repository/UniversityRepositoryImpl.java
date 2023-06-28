package com.example.lab2.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UniversityRepositoryImpl implements IUniversityRepository {

    ArrayList<Course> courses;

    ArrayList<Student> students;

    public UniversityRepositoryImpl() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
    }


    public void addCourse(Course course) {
        courses.add(course);
    }

    public boolean deleteCourse(Course course) {
        return courses.remove(course);
    }

    public List<Course> getAllCourse() {
        return courses;
    }

    public List<Student> getAllStudent() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void deleteStudent(Student student) {
        students.remove(student);
    }

}
