package com.example.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class Student {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String major;

    private List<Course> coursesTaken;

    public void addCourse(Course course) {
        coursesTaken.add(course);
    }
}
