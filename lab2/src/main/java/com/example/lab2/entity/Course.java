package com.example.lab2.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter @NoArgsConstructor
public class Course implements Serializable {
    private long id;
    private String name;
    private int code;

    public Course(long id, String name, int code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }
}
