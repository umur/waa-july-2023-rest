package com.waa.lab2.service;

import com.waa.lab2.entity.Course;
import com.waa.lab2.entity.Student;
import com.waa.lab2.repository.CourseRepo;
import com.waa.lab2.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private StudentRepo studentRepo;
    public Course getCourseById(Long id){
        return courseRepo.findCourseById(id);
    }
    public List<Course> getAllCourses(){
        return courseRepo.findAllCourses();
    }
    public String addCourse(Course course){
        return courseRepo.addCourse(course);
    }
    public String deleteCourse(Long id){
        Course course=courseRepo.findCourseById(id);
        return courseRepo.deleteCourse(course);
    }
    public String updateCourse(Long id,Course course){
        return courseRepo.updateCourse(id, course);
    }

    @Override
    public List<Course> getCourseByStudentId(Long studentId) {
        Student std=studentRepo.findStudentById(studentId);
        return std.getCoursesTaken();
    }
}
