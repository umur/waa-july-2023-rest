package com.example.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor

public class Course {

    private Long id;

    private String name;

    private String code;
}
