package com.example.assignment_two.repository;

import com.example.assignment_two.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepo {
   private static List<Course> courses = new ArrayList<>();

   public static List<Course> getCourse(){
       return courses;
    }

   static{
       courses.add(
               new Course(1L, "Web Application Architecture", "WAA")
       );
       courses.add(
               new Course(2L, "Web Application Programming", "WAP")
       );
       courses.add(
               new Course(3L, "Modern Programming Practices", "MPP")
       );
   }

   public List<Course> findAll(){
       return courses;
   }

   public void create(Course course){
       Optional<Course> existing = courses.stream()
               .filter(c -> c.getId().equals(course.getId()))
               .findAny();

       if(existing.isPresent()) throw new RuntimeException(String.format("Course By ID: %d exists", course.getId()));
       courses.add(course);
   }

   public void update(Long id, Course course){
       Optional<Course> targetCourse = courses.stream()
               .filter(c -> c.getId().equals(id))
               .findFirst();

       if(targetCourse.isEmpty()) throw new RuntimeException(String.format("Could not find Course by ID: %d", id));
       courses.remove(targetCourse.get());
       courses.add(course);
   }

    public void delete(Long id){
        Optional<Course> targetCourse = courses.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();

        if(targetCourse.isEmpty()) throw new RuntimeException(String.format("Could not find Course by ID: %d", id));

        courses.remove(targetCourse.get());
    }


}
