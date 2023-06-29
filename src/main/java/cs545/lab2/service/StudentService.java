package cs545.lab2.service;

import cs545.lab2.entity.Course;
import cs545.lab2.entity.Student;

import java.util.List;

public interface StudentService {
    public boolean addStudent(Student student);
    public List<Student> getAllStudents() ;
    public Student getStudentById(int id);
    public void updateStudent(int id,Student student);

    public void deleteStudentById(int id);

    public List<Student> getStudentsByMajor(String major);
}
