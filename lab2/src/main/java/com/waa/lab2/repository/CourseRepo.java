package com.waa.lab2.repository;

import com.waa.lab2.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
    private List<Course> courses=new ArrayList<>();
    public Course findCourseById(Long id){
        for(Course course: courses){
            if(course.getId()==id){
                return course;
            }
        }
        return null;
    }
    public List<Course> findAllCourses(){
        return courses;
    }
    public String addCourse(Course course){
        courses.add(course);
        return "course added";
    }
    public String deleteCourse(Course course){
        courses.remove(course);
        return "course deleted";
    }
    public String updateCourse(Long id,Course course){
        for(Course c:courses){
            if(c.getId()==id){
                c.setName(course.getName());
                c.setCode(course.getCode());

                return "course updated";
            }
        }
        return "course not updated";
    }
}
