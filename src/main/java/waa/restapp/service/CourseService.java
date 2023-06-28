package waa.restapp.service;

import waa.restapp.domain.Course;

import java.util.List;

public interface CourseService {
    void create(Course course);

    List<Course> findAll();

    Course findOne(Integer id);

    Course update(Integer id, Course course);
    void delete(Integer id);
}
