package com.example.lab2.repository;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    int id;
    String firstName;
    String lastName;
    String email;
    String major;
    ArrayList<Integer> coursesTaken;

}
