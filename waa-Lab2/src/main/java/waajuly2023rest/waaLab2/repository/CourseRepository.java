package waajuly2023rest.waaLab2.repository;

import org.springframework.stereotype.Repository;
import waajuly2023rest.waaLab2.model.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CourseRepository {

    static List<Course> courses = new ArrayList<>();


    public void createCourse(Course course) {
        courses.add(course);
    }


    public void updateCourse(Course course, int courseId)  {
        courses= courses.stream()
                .map(c-> {
                    if (c.getCourseId() == courseId) {
                        c.setCourseId(course.getCourseId());
                        c.setCode(course.getCode());
                    }
                    return c;
                }).collect(Collectors.toList());
    }


    public void deleteCourse(int courseId) {
        courses.remove(courseId);
    }


    public List<Course> getAllCouses() {
        return courses;
    }


    public List<Course> getCoursesByStudentId(int studentId) {
        return courses.stream()
                .filter(course -> course.getStudent().getStudentId() == studentId)
                .collect(Collectors.toList());
    }


    public Course getCourse(int courseId) {
        return courses.get(courseId);
    }
}



