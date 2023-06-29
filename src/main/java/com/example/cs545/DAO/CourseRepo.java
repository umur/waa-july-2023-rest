package com.example.cs545.DAO;


import com.example.cs545.Domain.Course;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
    static List<Course> courses= new ArrayList<>();

    public void create(Course course){
        courses.add(course);
    }

    public List<Course> getAll(){
        return courses;
    }

    public void update(Long id,Course course){
        for(Course cour : courses){
            if(cour.getId()==id){
                courses.remove(cour);
                courses.add(course);
            }

        }
    }
    public void delete(Long id){
        for(Course cour : courses){
            if(cour.getId()==id) {
                courses.remove(cour);
                return;
            }
        }
    }
    public Course getCourseById(Long id){
        for(Course course : courses){
            if(course.getId()==id) {
                return course;
            }
        }
        return null;
    }

}
