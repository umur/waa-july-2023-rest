package com.example.demo.repository;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    private List<Student> students;

    public StudentRepository() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void updateStudent(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == student.getId()) {
                students.set(i, student);
                break;
            }
        }
    }

    public void deleteStudent(int studentId) {
        students.removeIf(student -> student.getId() == studentId);
    }

    public Student getStudentById(int studentId) {
        for (Student student : students) {
            if (student.getId() == studentId) {
                return student;
            }
        }
        return null;
    }

    public List<Student> getStudentsByMajor(String major) {
        List<Student> filteredStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getMajor().equalsIgnoreCase(major)) {
                filteredStudents.add(student);
            }
        }
        return filteredStudents;
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        Student student = getStudentById(studentId);
        if (student != null) {
           return student.getCoursesTaken();
        }
        return null;
    }

    public List<Student> getAllStudents() {
        return students;
    }
}
