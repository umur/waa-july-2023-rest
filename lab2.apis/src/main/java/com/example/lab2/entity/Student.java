package com.example.lab2.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Student {
    private long id;
    private String firstName;
    private String  lastName;
    private String email;
    private String major;
    private List<Course> coursesTaken;
}
