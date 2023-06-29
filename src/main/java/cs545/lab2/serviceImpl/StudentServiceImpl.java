package cs545.lab2.serviceImpl;

import cs545.lab2.entity.Course;
import cs545.lab2.entity.Student;
import cs545.lab2.repository.StudentRepo;
import cs545.lab2.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;
    public boolean addStudent(Student student){
        return studentRepo.save(student);


    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }
    public Student getStudentById(int id){
        return studentRepo.findById(id);

    }
    public void updateStudent(int id,Student student){
        studentRepo.update(id,student);

    }

    public void deleteStudentById(int id){
        studentRepo.deleteById(id);

    }

    public List<Student> getStudentsByMajor(String major){
        return studentRepo.getStudentsByMajor(major);

    }
}
