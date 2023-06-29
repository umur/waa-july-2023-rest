package com.waa.lab2.repository;

import com.waa.lab2.entity.Course;
import com.waa.lab2.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class StudentRepo {
    private List<Student> students=new ArrayList<>();

    public Student findStudentById(Long id){
        for(Student student: students){
            if(student.getId()==id){
                return student;
            }
        }
        return null;
    }
    public List<Course> findCoursesByStudentId(Long studentId){
        for(Student student:students){
            if(student.getId().equals(studentId)) {
                return student.getCoursesTaken();
            }
        }
        return null;
    }
    public List<Student> findStudentsByMajor(String major){
        List<Student>list=new ArrayList<>();
        for(Student student: students){
            if(student.getMajor().equals(major)){
                list.add(student);
            }
        }
        return list;
    }
    public List<Student> findAllStudents(){
        return students;
    }
    public String addStudent(Student student){
        students.add(student);
        return "student added";
    }
    public String deleteStudent(Long id){
        Student std=this.findStudentById(id);
        students.remove(std);
        return "student removed";
    }
    public String updateStudent(Long id, Student std){
        for(Student student: students){
            if(student.getId()==id){
                student.setMajor(std.getMajor());
                student.setEmail(std.getEmail());
                student.setCoursesTaken(std.getCoursesTaken());
                student.setLastName(std.getLastName());
                student.setFirstName(std.getFirstName());
                return "student has been updated";
            }
        }
        return "no update made";
    }
}
