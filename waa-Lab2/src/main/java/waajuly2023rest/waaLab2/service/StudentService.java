package waajuly2023rest.waaLab2.service;


import waajuly2023rest.waaLab2.model.Student;
import java.util.List;

public interface StudentService {



    void create(Student student);

    void update(Student student, int studentId);

    void delete(int studentId);

    List<Student> getAllStudents();
    List<Student> getStudentByMajor(String major);

    List<Student> getStudentsByMajor(String major);
}
