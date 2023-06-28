package waajuly2023rest.waaLab2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import waajuly2023rest.waaLab2.model.Student;
import waajuly2023rest.waaLab2.repository.StudentRepository;
import waajuly2023rest.waaLab2.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public void create(Student student) {
        studentRepository.createStudent(student);
    }

    @Override
    public void update(Student student, int studentId){
      studentRepository.updateStudent(student,studentId);
    }
    @Override
    public void delete(int studentId){
        studentRepository.deleteStudent(studentId);
    }
    @Override
    public List<Student> getAllStudents(){
        return studentRepository.getAllStudents();
    }

    @Override
    public List<Student> getStudentByMajor(String major) {
        return null;
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
       return studentRepository.getStudentByMajor(major);
    }
}
