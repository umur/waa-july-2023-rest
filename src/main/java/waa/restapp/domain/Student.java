package waa.restapp.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Student {
    private Integer id;
    private String firstName, lastName, email, major;
    private List<Course> coursesTaken;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Student student)) return false;
        return id.equals(student.getId());
    }
}
