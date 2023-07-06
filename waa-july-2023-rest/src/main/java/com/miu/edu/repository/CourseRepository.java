package com.miu.edu.repository;

import com.miu.edu.model.Course;
import com.miu.edu.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {

    static List<Course> courses = new ArrayList<>();


    public void create(Course course) {

        courses.add(course);
    }

    public List<Course> findAll() {
        return courses;
    }

    public Course findById(Long id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return new Course();
    }



}
