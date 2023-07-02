package com.example.lab2.service;

import com.example.lab2.exceptions.EntityNotFoundException;
import com.example.lab2.repository.Course;
import com.example.lab2.repository.IUniversityRepository;
import com.example.lab2.repository.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UniversityServices implements IUniversityServices{


    final IUniversityRepository universityRepository;


    public List<Student> getAllStudentsByMajor(String major) {
        List<Student> studentList = universityRepository.getAllStudent();
        return studentList.stream().filter(student -> student.getMajor().equals(major)).collect(Collectors.toList());
    }

    public Student getStudentCoursesByStudentId(int studentId) throws Exception {
        List<Student> studentList = universityRepository.getAllStudent();
        Student requstedStudent = null;
        for (Student student : studentList) {
            if (student.getId() == studentId)
                requstedStudent = student;
        }

        if (requstedStudent == null)
            throw new Exception("Student not found!");

        return requstedStudent;
    }

    public void addCourse(Course course) {
        universityRepository.addCourse(course);
    }


    public void deleteCourse(Course course){
       if(!universityRepository.deleteCourse(course)){
           throw new EntityNotFoundException("Course not found");
       }
    }

    public List<Course> getAllCourse() {
        return universityRepository.getAllCourse();
    }

    public List<Student> getAllStudent() {
        return universityRepository.getAllStudent();
    }

    public void addStudent(Student student) {
        universityRepository.addStudent(student);
    }

    public void deleteStudent(Student student) {
        universityRepository.deleteStudent(student);
    }

}
