package com.example.lab2.repository;

import com.example.lab2.entity.Course;
import com.example.lab2.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
    static List<Student> students = new ArrayList<>();

    public StudentRepo() {
        Student student1 = new Student();
        student1.setId(1L);
        student1.setFirstName("Mahmoud");
        student1.setLastName("Ali");
        student1.setEmail("m@gmail.com");
        student1.setMajor("cs");

        List<Course> student1Courses = new ArrayList<Course>();
        Course course1 = new Course();
        course1.setId(1L);
        course1.setName("waa");
        course1.setCode("aaa");

        Course course2 = new Course();
        course2.setId(2L);
        course2.setName("data base");
        course2.setCode("123");

        student1Courses.add(course1);
        student1Courses.add(course2);

        student1.setCoursesTaken(student1Courses);

        students.add(student1);
    }

    public void create(Student student) {
        this.students.add(student);
    }

    public void update(long id, Student student) {
        for (var c : students) {
            if (c.getId() == id) {
                c.setFirstName(student.getFirstName());
                c.setLastName(student.getLastName());
                c.setEmail(student.getEmail());
                c.setMajor(student.getMajor());
                c.setCoursesTaken(student.getCoursesTaken());
            }
        }

    }

    public void delete(long id) {
        Student studentInDB = null;

        for (var student : students) {
            if (student.getId() == id) {
                studentInDB = student;
                break;
            }
        }

        if (studentInDB != null) {
            students.remove(studentInDB);
        }
    }

    public Student getById(long id) {
        for (var student : students) {
            if (student.getId() == id)
                return student;
        }
        return null;
    }

    public List<Student> getAll() {
        return students;
    }

    public List<Student> getByMajor(String major) {
        List<Student> studentsByMajor = new ArrayList<>();
        for (Student student : students) {
            if (student.getMajor().equals(major))
                studentsByMajor.add(student);
        }

        return studentsByMajor;
    }

    public  List<Course> getCoursesByStudentId(long id){
        for (Student student : students) {
            if (student.getId() == id) {
                return student.getCoursesTaken();
            }
        }
        return  null;
    }
}
