package waa.restapp.repository;

import org.springframework.stereotype.Repository;
import waa.restapp.domain.Course;
import waa.restapp.domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class StudentRepository {
    static List<Student> studentList = new ArrayList<>();

    public void create(Student student){
        studentList.add(student);
    }

    public List<Student> findAll(){
        return studentList;
    }

    public Student findOne(int id){
        return studentList.get(id);
    }

    public List<Student> getStudentsByMajor(String major){
        return studentList.stream().filter(x -> Objects.equals(x.getMajor(), major)).toList();
    }

    public List<Course> getCoursesByStudentId(int studentId){
        Student student = findOne(studentId);
        return student.getCoursesTaken();
    }

    public Student update(Integer id, Student student){
        Student student1 = findOne(id);
        student1 = student;
        return student1;
    }

    public void delete(int id){
        studentList.remove(id);
    }
}
