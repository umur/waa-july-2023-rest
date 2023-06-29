package waa.restapp.service;

import waa.restapp.domain.Course;
import waa.restapp.domain.Student;

import java.util.List;

public interface StudentService {
    Student create(Student student);

    List<Student> findAll();

    Student findById(Integer id);

    List<Student> getStudentsByMajor(String major);

    List<Course> getCoursesByStudentId(int studentId);

    Student update(Integer id, Student course);

    void delete(Integer id);
}
