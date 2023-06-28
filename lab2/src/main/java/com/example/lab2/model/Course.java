package com.example.lab2.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Data

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
}
