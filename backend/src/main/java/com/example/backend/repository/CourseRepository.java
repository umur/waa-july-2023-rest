package com.example.backend.repository;

import com.example.backend.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class CourseRepository {
    private static List<Course> courses;
    private static Long courseId;

    static {
        courseId = 0L;
        courses = new ArrayList<>();
        courses.add(new Course(++courseId, "Modern Programming", "CS4013A"));
        courses.add(new Course(++courseId, "Web Application Programming", "CS4725B"));
        courses.add(new Course(++courseId, "Mobile Device Programming", "CS4734"));
        courses.add(new Course(++courseId, "Enterprise Architecture", "CS5446"));
        courses.add(new Course(++courseId, "Web Application Architecture", "CS545"));
    }

    public void create(Course course) {
        course.setId(++courseId);
        courses.add(course);
    }

    public Course getById(Long id) {

        for (Course c : courses) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public List<Course> getAll() {
        return courses;
    }

    public void update(Course course) {

        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == course.getId()) {
                courses.set(i, course);
                break;
            }
        }
    }

    public void delete(Long id) {
        for (Iterator<Course> iterator = courses.iterator(); iterator.hasNext(); ) {
            Course item = iterator.next();
            if (item.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }

}
