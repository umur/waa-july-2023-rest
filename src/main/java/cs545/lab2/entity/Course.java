package cs545.lab2.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Course {
    Long id;
    String name;
    String code;
    Integer studentId;
}
