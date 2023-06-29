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

    public Student create(Student student){
        studentList.add(student);
        return student;
    }

    public List<Student> findAll(){
        return studentList;
    }

    public Student findById(Integer id){
        return studentList.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Student> getStudentsByMajor(String major){
        return studentList.stream().filter(x -> Objects.equals(x.getMajor(), major)).toList();
    }

    public List<Course> getCoursesByStudentId(int studentId){
        Student student = findById(studentId);
        return student.getCoursesTaken();
    }

    public Student update(Integer id, Student student){
        return studentList.stream().filter(x -> x.getId().equals(id)).findFirst().map(v -> {
            v.setFirstName(student.getFirstName());
            v.setLastName(student.getLastName());
            v.setEmail(student.getEmail());
            v.setMajor(student.getMajor());
            v.setCoursesTaken(student.getCoursesTaken());
            return v;
        }).orElse(null);
    }

    public void delete(int id){
        studentList.remove(findById(id));
    }
}
