package com.example.demo.repository;

import com.example.demo.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    private List<Course> courses= new ArrayList<>();



    public void addCourse(Course course) {
        courses.add(course);
    }

    public void updateCourse(Course course) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == course.getId()) {
                courses.set(i, course);
                break;
            }
        }
    }

    public void deleteCourse(int courseId) {
        courses.removeIf(course -> course.getId() == courseId);
    }

    public Course getCourseById(int courseId) {
        return courses.get(courseId);
    }
    public List<Course> getAllCourses() {
        return courses;
    }
}
