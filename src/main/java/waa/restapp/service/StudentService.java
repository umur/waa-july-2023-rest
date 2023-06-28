package waa.restapp.service;

import waa.restapp.domain.Course;
import waa.restapp.domain.Student;

import java.util.List;

public interface StudentService {
    public void create(Student student);

    List<Student> findAll();

    Student findOne(Integer id);

    List<Student> getStudentsByMajor(String major);

    List<Course> getCoursesByStudentId(int studentId);

    Student update(Integer id, Student course);

    void delete(Integer id);
}
