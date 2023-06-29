package waa.restapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import waa.restapp.domain.Course;
import waa.restapp.domain.Student;
import waa.restapp.repository.StudentRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    @Override
    public Student create(Student student) {
        if (student.getCoursesTaken() == null) throw new RuntimeException("Courses cannot be empty");
        if (student.getMajor().isEmpty()) throw new RuntimeException("You must provide a major");
        if (student.getEmail().isEmpty() || !student.getEmail().contains("@")) throw new RuntimeException("Invalid email");
        if (student.getLastName().isEmpty() || student.getFirstName().isEmpty()) throw new RuntimeException("Invalid first name or last name");
        return studentRepository.create(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepository.getStudentsByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        return studentRepository.getCoursesByStudentId(studentId);
    }

    @Override
    public Student update(Integer id, Student student) {
        return studentRepository.update(id, student);
    }

    @Override
    public void delete(Integer id) {
        studentRepository.delete(id);
    }
}
