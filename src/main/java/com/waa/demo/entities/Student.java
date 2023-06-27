package com.waa.demo.entities;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Student {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<Course> coursesTaken=new ArrayList<>();

}
