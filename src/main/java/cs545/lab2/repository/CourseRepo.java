package cs545.lab2.repository;

import cs545.lab2.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
 static List<Course> courses=new ArrayList<>();
    public void save(Course course){
        courses.add(course);
    }
    public List<Course> findAll(Course course){
        return courses;
    }
    public Course findById(Long id) {
        for (Course course : courses) {
            if (id == course.getId())
                return course;
        }
    return null;

    }
    public void deleteById(Long id){
        for(Course course:courses){
            if(id==course.getId())
                courses.remove(course);
        }
    }
    public void update(Long id,Course course){
        if(id==course.getId()) {
            course.setCode(course.getCode());
            course.setName(course.getName());
        }
        courses.add(course);

        }
    public List <Course> getCoursesByStudentId(Integer studentId) {
        List<Course> list=new ArrayList<>();
        for (Course course : courses) {
            if (studentId==course.getStudentId()){
                list.add(course);
            }

        }
        return list;
    }
}
