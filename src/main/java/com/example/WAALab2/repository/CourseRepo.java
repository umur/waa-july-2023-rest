package com.example.WAALab2.repository;

import com.example.WAALab2.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Repository
public class CourseRepo {

    private static List<Course> courses = new ArrayList<>();

    public List<Course> get(){
        return  courses;
    }

    public Course get(Long id){
        try {
            return courses.stream()
                    .filter(x -> x.getId().equals(id))
                    .findAny()
                    .get();
        }
        catch (NoSuchElementException ex)
        {
            throw new RuntimeException("Course Not Found.");
        }

    }

    public Course create(Course course){
        if(courses.stream()
                .anyMatch(x -> x.getId().equals(course.getId())))
            throw  new RuntimeException("Course Already Added");

        courses.add(course);

        return course;
    }

    public Course update(Course course){

        for(Course current: courses){
            if (current.getId().equals(course.getId())){
                current = course;
                return current;
            }
        }

        throw new RuntimeException("Course Not Found.");
    }

    public Course delete(Long id){
        Course  course = get(id);
        courses.remove(course);
        return course;
    }
}
