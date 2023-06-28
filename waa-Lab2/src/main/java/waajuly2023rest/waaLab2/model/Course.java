package waajuly2023rest.waaLab2.model;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Course {

    private Long courseId;
    private String name;
    private String code;
    private Student student;

}
