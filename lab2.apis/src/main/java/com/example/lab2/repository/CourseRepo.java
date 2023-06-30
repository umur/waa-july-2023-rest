package com.example.lab2.repository;

import com.example.lab2.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
    static List<Course> courses = new ArrayList<>();

    public CourseRepo() {
        Course course1 = new Course();
        course1.setId(1L);
        course1.setName("waa");
        course1.setCode("aaa");

        Course course2 = new Course();
        course2.setId(2L);
        course2.setName("waa");
        course2.setCode("aaa");

        Course course3 = new Course();
        course3.setId(3L);
        course3.setName("waa");
        course3.setCode("aaa");

        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
    }

    public void create(Course course) {
        this.courses.add(course);
    }

    public void update(long id, Course course) {
        for (var c : courses) {
            if (c.getId() == id) {
                c.setName(course.getName());
                c.setCode(course.getCode());
            }
        }

    }

    public void delete(long id) {
        Course courseInDB = null;

        for (var course : courses) {
            if (course.getId() == id) {
                courseInDB = course;
                break;
            }
        }

        if (courseInDB != null) {
            courses.remove(courseInDB);
        }
    }

    public Course getById(long id) {
        for (var course : courses) {
            if (course.getId() == id)
                return course;
        }
        return null;
    }

    public List<Course> getAll() {
        return courses;
    }

}
