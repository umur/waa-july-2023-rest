package com.miu.edu.repository;

import com.miu.edu.model.Course;
import com.miu.edu.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
static List<Student> students = new ArrayList<>();

    public void create(Student student) {

        students.add(student);
    }

    public List<Student> findAll() {
        return students;
    }

    public Student findById(Long id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return new Student();
    }

    public List<Student> findByMajor(String major){

        return new ArrayList<Student>();
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        return students.stream().filter(s -> s.getId() == studentId).findFirst().get().getCoursesTaken();
    }
}
