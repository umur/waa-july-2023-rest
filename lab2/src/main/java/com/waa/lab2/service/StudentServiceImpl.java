package com.waa.lab2.service;

import com.waa.lab2.entity.Course;
import com.waa.lab2.entity.Student;
import com.waa.lab2.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Override
    public List<Student> getStudentByMajor(String major) {
        return studentRepo.findStudentsByMajor(major);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepo.findStudentById(id);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepo.findAllStudents();
    }

    @Override
    public List<Course> getCoursesByStudentId(Long studentId) {

        return studentRepo.findCoursesByStudentId(studentId);
    }

    @Override
    public String addStudent(Student student) {
        return studentRepo.addStudent(student);
    }

    @Override
    public String updateStudent(Long id, Student student) {
        return studentRepo.updateStudent(id, student);
    }

    @Override
    public String deleteStudent(Long id) {
        Student std=studentRepo.findStudentById(id);
        if(std!=null){
            studentRepo.deleteStudent(id);
            return "student deleted";
        }
        return "student doesn't exist";
    }

}
