package com.lab2.repository;

import com.lab2.entity.Course;
import com.lab2.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentRepository {
    static List<Student> students = new ArrayList<>();
    static {
        students.add(new Student(1, "Amrit", "Bhattarai", "amrit@miu.edu", "WAP", new ArrayList<Course>()));
        students.add(new Student(1, "Pratap", "KC", "pratap@miu.edu", "Big Data", new ArrayList<Course>()));
        students.add(new Student(1, "Madhav", "Timilsina", "madhav@miu.edu", "Algorithm", new ArrayList<Course>()));
    }
    public void save(Student stu){
      students.add(stu);
    }
    public Student getById(int id) {
       return students.stream()
                .filter(s->s.getId()==id)
                .findFirst()
                .get();
    }
    public List<Student> getAll(){
        return students;
    }

    public void update(int id, Student student){
        students.stream()
                .filter(s->s.getId()==id)
                .findFirst()
                .ifPresent(s->{
                    if(student.getFirstName() !=null)
                        s.setFirstName(student.getFirstName());
                    if (student.getLastName() != null)
                        s.setLastName(student.getLastName());
                    if (student.getEmail() != null)
                        s.setEmail(student.getEmail());
                    if (student.getMajor() != null)
                        s.setMajor(student.getMajor());
                });
    }
    public void addCourseTakenByID(int id, Course course) {
        students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .ifPresent(
                    student -> {
                        if (student.getCoursesTaken() == null) {
                            student.setCoursesTaken(new ArrayList<Course>());
                        }
                    student.getCoursesTaken().add(course);
                }
        );

    }


    public void delete(int id) {
        students.removeIf(s -> s.getId() == id);
    }

    public List<Student> getStudentsByMajor(String major) {
        return students.stream()
                .filter(s -> s.getMajor().equals(major))
                .collect(Collectors.toList());
    }


    public List<Course> getCoursesByStudentId(int studentId) {
        return students.stream()
                .filter(s -> s.getId() == studentId)
                .findFirst().get().getCoursesTaken();
    }

}
