package online.moumini.lab2.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import online.moumini.lab2.model.Student;

@Repository
public class StudentRepository {
    private List<Student> students;

    public StudentRepository() {
        this.students = new ArrayList<>();
        initializeDummyData();
    }

    private void initializeDummyData() {
        Student student1 = new Student();
        student1.setId(1);
        student1.setFirstName("John");
        student1.setLastName("Doe");
        student1.setEmail("john.doe@example.com");
        student1.setMajor("Computer Science");

        Student student2 = new Student();
        student2.setId(2);
        student2.setFirstName("Jane");
        student2.setLastName("Smith");
        student2.setEmail("jane.smith@example.com");
        student2.setMajor("Biology");

        Student student3 = new Student();
        student3.setId(3);
        student3.setFirstName("Mike");
        student3.setLastName("Johnson");
        student3.setEmail("mike.johnson@example.com");
        student3.setMajor("Mathematics");

        students.add(student1);
        students.add(student2);
        students.add(student3);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudentById(int id) {
        return new Student();
    }

    public List<Student> getStudentsByMajor(String major) {
        return new ArrayList<Student>();
    }
}
