package waa.restapp.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class Student {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<Course> coursesTaken;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Student student)) return false;
        return id.equals(student.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, major);
    }
}
