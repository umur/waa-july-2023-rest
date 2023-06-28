package waa.restapp.domain;

import lombok.*;

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
}
