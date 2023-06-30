package com.example.WAALab2.repository;

import com.example.WAALab2.entity.Course;
import com.example.WAALab2.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class StudentRepo {

    private static List<Student> students = new ArrayList<>();

    public List<Student> get() {
        return students;
    }

    public Student get(Long id){
        try {
            return students.stream()
                    .filter(x -> x.getId().equals(id))
                    .findAny()
                    .get();
        }
        catch (NoSuchElementException ex)
        {
            throw new RuntimeException("Course Not Found.");
        }
    }

    public  List<Student> getStudentsByMajor(String major){
        return students.stream()
                .filter(x -> x.getMajor().equals(major))
                .toList();
    }

    public  List<Course> getCoursesByStudentId(Long studentId)
    {
        Student student = get(studentId);
        return student.getCoursesTaken();
    }

    public Student create(Student student){
        if(students.stream()
                .anyMatch(x -> x.getId().equals(student.getId())))
            throw  new RuntimeException("Student Already Added");

        students.add(student);

        return student;
    }

    public Student update(Student student){

        for(int i = 0; i < students.size(); i++){
            if (students.get(i).getId().equals(student.getId())){
                students.set(i, student);
                return student;
            }
        }

        throw new RuntimeException("Student Not Found.");
    }

    public Student delete(Long id){
        Student  student = get(id);
        students.remove(student);
        return student;
    }



}
