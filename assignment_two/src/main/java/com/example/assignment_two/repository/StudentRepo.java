package com.example.assignment_two.repository;

import com.example.assignment_two.entity.Course;
import com.example.assignment_two.entity.Student;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepo {

    private static List<Student> students = new ArrayList<>();

    static{

        List<Course> c1 = new ArrayList<>();
        c1.add(CourseRepo.getCourse().get(0));
        c1.add(CourseRepo.getCourse().get(1));

        List<Course> c2 = new ArrayList<>();
        c2.add(CourseRepo.getCourse().get(1));

        List<Course> c3 = new ArrayList<>();
        c3.add(CourseRepo.getCourse().get(0));
        c3.add(CourseRepo.getCourse().get(2));


        students.add(
                new Student(1L, "Bitsu", "Hello", "a@gmail.com", "Computer Science", c1)
        );
        students.add(
                new Student(2L, "Nati", "World", "c@gmail.com", "Computer Science", c2)
        );
        students.add(
                new Student(3L, "Maggi", "yeah", "y@gmail.com", "Computer Science", c3)
        );
    }

    public List<Student> findAll(){
        return students;
    }

    public void create(Student student){
        Optional<Student> existing = students.stream()
                        .filter(s -> s.getId().equals(student.getId()))
                                .findAny();

        if(existing.isPresent()) throw new RuntimeException(String.format("Student By ID: %d exists", student.getId()));
        students.add(student);
    }

    public void update(Long id, Student student){
        Optional<Student> targetStudent = students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();

        if(targetStudent.isEmpty()) throw new RuntimeException(String.format("Student By Id: %d Not Found", id));

        students.remove(targetStudent.get());
        students.add(student);
    }

    public void delete(Long id){
        Optional<Student> targetStudent = students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();

        if(targetStudent.isEmpty()) throw new RuntimeException(String.format("Student By Id: %d Not Found", id));

        students.remove(targetStudent.get());
    }

    public List<Student> getStudentsByMajor(String major){
        return students.stream().filter(student -> student.getMajor().equalsIgnoreCase(major)).toList();
    }

    public List<Course> getCoursesByStudentId(@PathVariable Long id){

        Optional<Student> student = students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();

        if(student.isEmpty()) throw new RuntimeException(String.format("Student By Id: %d Not Found", id));

        return student.get().getCoursesTaken();

    }

}
