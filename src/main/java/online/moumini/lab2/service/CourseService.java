package online.moumini.lab2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.moumini.lab2.model.Course;
import online.moumini.lab2.repository.CourseRepository;

@Service
public class CourseService {
    @Autowired
     private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }

    public Course getCourseById(int id) {
        return courseRepository.getCourseById(id);
    }

    public Course createCourse(Course course) {
        // Generate a new ID for the course
        int newId = generateNewCourseId();
        course.setId(newId);

        // Save the course using the repository
        return courseRepository.saveCourse(course);
    }

    public boolean deleteCourseById(int id) {
        return courseRepository.deleteCourseById(id);
    }

    private int generateNewCourseId() {
        List<Course> courses = courseRepository.getAllCourses();
        int maxId = 0;
        for (Course course : courses) {
            if (course.getId() > maxId) {
                maxId = course.getId();
            }
        }
        return maxId + 1;
    }
}
