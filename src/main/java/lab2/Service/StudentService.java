package lab2.Service;

import lab2.Model.Course;
import lab2.Model.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getAll();
    public Student getRecordById(Long id);
    public void create(Student student);
    public Student update(Long id,Student student);
    public void delete (Long id);
    public List<Student> getStudentsByMajor(String major);
    public void addCourse(Long studentId,Long courseId);
    public List<Course> getCoursesByStudentId(Long studentId);
}
