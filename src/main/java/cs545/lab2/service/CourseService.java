package cs545.lab2.service;

import cs545.lab2.entity.Course;

import java.util.List;

public interface CourseService {
    public void addCourse(Course course);

    public List<Course> getAllCourses(Course course);

    public Course getCourseById(Long id);

    public void deleteCourseById(Long id);

    public void updateCourse(Long id, Course course);

    public List<Course> getCoursesByStudentId(Integer studentId);
}
