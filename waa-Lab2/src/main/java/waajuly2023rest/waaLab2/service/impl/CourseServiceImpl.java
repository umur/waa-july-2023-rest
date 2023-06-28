package waajuly2023rest.waaLab2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import waajuly2023rest.waaLab2.model.Course;
import waajuly2023rest.waaLab2.repository.CourseRepository;
import waajuly2023rest.waaLab2.repository.StudentRepository;
import waajuly2023rest.waaLab2.service.CourseService;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;


    @Override
    public void createCourse(Course course) {
       courseRepository.createCourse(course);
    }
    @Override
    public void updateCourse(Course course, int courseId) {
     courseRepository.updateCourse(course,courseId);
    }
    @Override
    public void deleteCourse(int courseId) {
       courseRepository.deleteCourse(courseId);
    }
    @Override
    public Course getCourse(int courseId) {
        return courseRepository.getCourse(courseId);
    }

    @Override
    public List<Course> getAllCouses() {
        return courseRepository.getAllCouses();
    }
    public List<Course> getCoursesByStudentId(int studentId) {
    return courseRepository.getCoursesByStudentId(studentId);
    }



}
