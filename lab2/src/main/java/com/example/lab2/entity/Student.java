package com.example.lab2.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter @Setter @NoArgsConstructor
public class Student implements Serializable {

    private long id;
    private String firstname;
    private String lastName;
    private String email;
    private String major;
    private List<Course> coursesTaken;

    public Student(long id, String firstname, String lastName, String email, String major, List<Course> coursesTaken) {
        this.id = id;
        this.firstname = firstname;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
        this.coursesTaken = coursesTaken;
    }
}
