package com.waa_lab2.backend.repository;

import com.waa_lab2.backend.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    static List<Course> courseList = new ArrayList<>();

    static {
        courseList.add(new Course(1,"Fundamental Programming Practices","CS390"));
        courseList.add(new Course(2,"Modern Programming Practice","CS401"));
        courseList.add(new Course(3,"Web Application Programming","CS472"));
        courseList.add(new Course(4,"Web Application Architecture","CS545"));
        courseList.add(new Course(5,"Enterprise Architecture","CS544"));
        courseList.add(new Course(6,"Algorithms","CS535"));
    }

    public void save (Course course){
        courseList.add(course);
    }
    public List<Course> getAll() {
        return courseList;
    }
    public Course getByID(int courseId) {
        return courseList.stream()
                .filter(c->c.getId()==courseId)
                .findFirst()
                .get();
    }
    public void update(int id, Course course){
        courseList.stream()
                .filter(c->c.getId()==id)
                .findFirst()
                .ifPresent(
                        c->{
                            if (course.getName()!= null & course.getCode()!=null) {
                                c.setName(course.getName());
                                c.setCode(course.getCode());
                            }
                        }
                );
    }

    public void delete(int courseId) {
        courseList.removeIf(c->c.getId()==courseId);
    }
}
