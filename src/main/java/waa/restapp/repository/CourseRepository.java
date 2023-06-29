package waa.restapp.repository;

import org.springframework.stereotype.Repository;
import waa.restapp.domain.Course;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    static List<Course> courseList = new ArrayList<>();

    public Course create(Course course){
        courseList.add(course);
        return course;
    }

    public List<Course> findAll(){
        return courseList;
    }

    public Course findById(int id){
        return courseList.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
    }

    public Course update(Integer id, Course course){
        return courseList.stream().filter(x -> x.getId().equals(id)).findFirst().map(v -> {
            v.setName(course.getName());
            v.setCode(course.getCode());
            return v;
        }).orElse(null);
    }

    public void delete(int id){
        courseList.remove(findById(id));
    }

}
