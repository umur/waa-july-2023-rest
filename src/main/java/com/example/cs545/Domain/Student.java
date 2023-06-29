package com.example.cs545.Domain;


import lombok.Data;

import java.util.List;

@Data
public class Student {
   private Long id;
   private String firstName;
   private String lastName;
   private String email;
   private String major;

   private List<Course> coursesTaken;

   public void  addCourse(Course course){
      coursesTaken.add(course);
   }

}
