package lab2.Service.impl;

import lab2.Model.Course;
import lab2.Model.Student;
import lab2.Repository.CourseRepo;
import lab2.Repository.StudentRepo;
import lab2.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;
    private final CourseRepo courseRepo;

    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo, CourseRepo courseRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo =   courseRepo;
    }

    public List<Student> getAll() {
        return studentRepo.getAll();
    }

    public Student getRecordById(Long id) {
        return studentRepo.getRecordById(id);
    }

    public void create(Student student) {
        if (student.getFirstName().equals("")) {
            throw new RuntimeException("Student firstname is required");
        }
        if (student.getLastName().equals("")) {
            throw new RuntimeException("Student lastname is required");
        }
        if (student.getMajor().equals("")) {
            throw new RuntimeException("Student major is required");
        }
        studentRepo.create(student);
    }

    public Student update(Long id, Student student) {
        if (student.getFirstName().equals("")) {
            throw new RuntimeException("Student firstname is required");
        }
        if (student.getLastName().equals("")) {
            throw new RuntimeException("Student lastname is required");
        }
        if (student.getMajor().equals("")) {
            throw new RuntimeException("Student major is required");
        }
        return studentRepo.update(id, student);
    }

    public void delete(Long id) {
        studentRepo.delete(id);
    }

    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major);
    }

    public void addCourse(Long studentId,Long courseId){
        Course course = courseRepo.getRecordById(courseId);
        studentRepo.addCourseToStudent(studentId ,course);
    }

    public List<Course> getCoursesByStudentId(Long studentId) {
        return studentRepo.getCoursesByStudentId(studentId);
    }
}
