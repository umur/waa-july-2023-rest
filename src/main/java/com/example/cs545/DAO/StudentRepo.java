package com.example.cs545.DAO;

import com.example.cs545.Domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
    static List<Student> students= new ArrayList<>();
    public void create(Student student){
        students.add(student);
    }

    public List<Student> getAll(){
        return students;
    }

    public void update(Long id,Student student){
        for(Student stu : students){
            if(stu.getId()==id){
                students.remove(stu);
                students.add(student);
            }

        }
    }
    public void delete(Long id){
        for(Student stu : students){
            if(stu.getId()==id) {
                students.remove(stu);
                return;
            }

        }
    }
    public Student getStudentById(Long id){
        for(Student stu : students){
            if(stu.getId()==id) {
                return stu;
            }
    }
    return null;
    }

   public List<Student> getStudentsByMajor(String major){
        List<Student> studentByMajor = new ArrayList<>();
       for(Student stu : students){
           if(stu.getMajor().equals(major)) {
              studentByMajor.add(stu);
           }
       }
       return studentByMajor;

    }


}
