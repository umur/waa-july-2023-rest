package waa.restapp.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Student {
    private int id;
    private String firstName, lastName, email, major;
    private List<Course> coursesTaken;
}
