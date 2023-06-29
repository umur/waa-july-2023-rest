package com.example.lab2.repository;

import com.example.lab2.entity.Course;
import com.example.lab2.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UniversityRepositoryImpl implements UniversityRepository {

    private List<Student> students = new ArrayList<>();
    private static int size = 1;

    public UniversityRepositoryImpl() {
        Course course = new Course(1, "WAA", 545);
        List<Course> courses = new ArrayList<>();
        courses.add(course);
        Student student = new Student(1, "Mirzokhidjon", "Ikromov", "mikromov@miu.edu", "CS", courses);
        students.add(student);
    }

    @Override
    public void createStudent(Student student) {
        student.setId(++size);
        students.add(student);
    }

    @Override
    public Student updateStudent(int studentId, Student student) {
        Student s = findStudentById(studentId);
        int index = students.indexOf(s);
        if (s == null)
            throw new RuntimeException("Student not found");
        s.setFirstname(student.getFirstname());
        s.setLastName(student.getLastName());
        s.setEmail(student.getEmail());
        s.setMajor(student.getMajor());
        s.setCoursesTaken(student.getCoursesTaken());
        students.set(index, s);
        return s;
    }

    @Override
    public void deleteStudent(int studentId) {
        Student student = findStudentById(studentId);
        students.remove(Optional.of(student).orElseThrow(() -> new RuntimeException("Student not found")));
    }

    @Override
    public Student findStudentById(int studentId) {
        return students.stream().filter(s -> s.getId() == studentId).findFirst().orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public List<Student> findAllStudents() {
        return students;
    }
}
