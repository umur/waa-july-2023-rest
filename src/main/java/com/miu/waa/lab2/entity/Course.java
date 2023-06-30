package com.miu.waa.lab2.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonSerialize
public class Course {
    private Long id;
    private String name;
    private String code;
}
