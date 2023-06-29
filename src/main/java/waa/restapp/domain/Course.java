package waa.restapp.domain;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
public class Course {
    private Integer id;
    private String name;
    private String code;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Course course)) return false;
        return id.equals(course.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code);
    }
}
