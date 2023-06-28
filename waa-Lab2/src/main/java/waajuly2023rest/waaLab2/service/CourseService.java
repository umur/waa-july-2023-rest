package waajuly2023rest.waaLab2.service;

import waajuly2023rest.waaLab2.model.Course;

import java.util.List;

public interface CourseService {

    abstract void createCourse(Course course);

    abstract void updateCourse(Course course, int courseId);
    abstract void deleteCourse(int courseId);
     abstract List<Course> getAllCouses();
    abstract List<Course> getCoursesByStudentId(int studentId);


    Course getCourse(int courseId);
}
