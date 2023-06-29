package com.example.backend.repository;

import com.example.backend.entity.Course;
import com.example.backend.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    private static List<Student> students;
    private static Long studentId = 0L;

    static {
        studentId = 0L;
        students = new ArrayList<>();
        Student student=new Student(++studentId, "Taha", "Elsayed", "t@gmail.com", "MSCS", new ArrayList<>());
        student.addCourse(new Course(4L, "Enterprise Architecture", "CS5446"));
        student.addCourse(new Course(5L, "Web Application Architecture", "CS545"));
        students.add(student);
//        students.add(new Student(++studentId, "Web Application Programming", "CS4725B"));
//        students.add(new Student(++studentId, "Mobile Device Programming", "CS4734"));
//        students.add(new Student(++studentId, "Enterprise Architecture", "CS5446"));
//        students.add(new Student(++studentId, "Web Application Architecture", "CS545"));
    }

    public void create(Student student) {
        student.setId(++studentId);
        students.add(student);
    }

    public Student getById(Long id) {

        for (Student c : students) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public List<Student> getAll() {
        return students;
    }

    public List<Student> getStudentsByMajor(String major) {
        return students
                .stream()
                .filter(s -> s.getMajor().equalsIgnoreCase(major))
                .collect(Collectors.toList());
    }

    public void update(Student student) {

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == student.getId()) {
                students.set(i, student);
                break;
            }
        }
    }

    public void delete(Long id) {
        for (Iterator<Student> iterator = students.iterator(); iterator.hasNext(); ) {
            Student item = iterator.next();
            if (item.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }

}
