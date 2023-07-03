package com.waa_lab2.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class Student {
    private int id;
    private String firstName;
    private String lastname;
    private String email;
    private String major;
    private List<Course> coursesTaken;
}
