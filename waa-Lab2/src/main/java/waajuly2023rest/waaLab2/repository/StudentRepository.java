package waajuly2023rest.waaLab2.repository;

import org.springframework.stereotype.Repository;
import waajuly2023rest.waaLab2.model.Student;
import waajuly2023rest.waaLab2.service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository  {

    List<Student> students = new ArrayList<>();


    public void createStudent(Student student) {
        students.add(student);

    }


    public void updateStudent(Student student, int studentId) {
        students = students.stream()
                .map(s-> {
                    if (s.getStudentId() == studentId) {
                        s.setFirstName(student.getFirstName());
                        s.setLastName(student.getLastName());
                        s.setMajor(student.getMajor());
                    }
                    return s;
                }).collect(Collectors.toList());
    }


    public void deleteStudent(int StudentId) {
        students.remove(StudentId);

    }

    public List<Student> getAllStudents() {
        return students;
    }

    public List<Student> getStudentByMajor(String major) {
       return students.stream()
                .filter(student -> student.getMajor().equals(major))
                .collect(Collectors.toList());
    }


    }


