package com.example.assignment_two.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Course {

    private Long id;
    private String name;
    private String code;
}
