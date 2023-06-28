package waajuly2023rest.waaLab2.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Student {

    private int StudentId;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<Course> coursestaken;
    private Course course;

}
