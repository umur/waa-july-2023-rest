package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<Course> coursesTaken;
}
