package com.waa.lab2.dto;

import com.waa.lab2.entity.Course;
import com.waa.lab2.entity.Student;
import lombok.Data;

import java.util.List;
@Data
public class StudentCourseDto {
    private Student student;
    private List<Course> courses;
}
