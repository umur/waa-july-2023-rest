package com.waa_lab2.backend.repository;

import com.waa_lab2.backend.model.Course;
import com.waa_lab2.backend.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    static List<Student> studentList = new ArrayList<>();

    static {
        studentList.add(new Student(1, "Pawan", "Shiwakoti", "pawan@abc.com", "Computer Science", new ArrayList<Course>()));
        studentList.add(new Student(2, "Amrit", "Bhattari", "amrit@abc.com", "Biology", new ArrayList<Course>()));
        studentList.add(new Student(3, "Sayal", "Aryal", "sayal@abc.com", "Computer Science", new ArrayList<Course>()));
        studentList.add(new Student(4, "Umur", "Inan", "umur@abc.com", "Biology", new ArrayList<Course>()));
    }

    public void save(Student student) {
        studentList.add(student);
    }
    public List<Student> getAll() {
        return studentList;
    }

    public Student getByID(int id) {
        return studentList.stream().filter(s -> s.getId() == id).findFirst().get();
    }

    public List<Student> getStudentsByMajor(String major){
        return studentList.stream()
                .filter(s->s.getMajor().equals(major))
                .toList();
    }

    public List<Course> getCoursesByStudentID(int id){
        return studentList.stream()
                .filter(s->s.getId()==id)
                .findFirst()
                .get()
                .getCoursesTaken();
    }

    public void update(int id, Student student) {
        studentList.stream().filter(s -> s.getId() == id).findFirst().ifPresent(s -> {
            if (student.getFirstName() != null) s.setFirstName(student.getFirstName());
            if (student.getLastname() != null) s.setLastname(student.getLastname());
            if (student.getEmail() != null) s.setEmail(student.getEmail());
            if (student.getMajor() != null) s.setMajor(student.getMajor());
        });
    }

    public void delete(int id) {
        studentList.removeIf(s -> s.getId() == id);
    }

}
