package lab2.Repository;

import lab2.Model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

@Repository
public class CourseRepo {

    private static int currentId = 1;
    List<Course> courses = new ArrayList<>();

    public List<Course> getAll(){
        return courses;
    }
    public Course getRecordById(Long id){
        Optional<Course> course  = courses.stream().filter(c -> c.getId().equals(id)).findAny();
        if (course.isEmpty()){
            throw new RuntimeException("Course not found");
        }
        return course.get();
    }
    public void create(Course course){
        course.setId(Long.valueOf(currentId++));
        this.courses.add(course);
    }
    public Course update(Long id,Course course){
        OptionalInt indexOpt = IntStream.range(0, courses.size())
                .filter(i -> id.equals(courses.get(i).getId()))
                .findFirst();
        if (indexOpt.isEmpty()){
            throw new RuntimeException("Course not found");
        }
        Course targetCourse = courses.get(indexOpt.getAsInt());
        course.setId(targetCourse.getId());
        courses.set(indexOpt.getAsInt(), course);
        return courses.get(indexOpt.getAsInt());
    }
    public void delete (Long id){
        OptionalInt indexOpt = IntStream.range(0, courses.size())
                .filter(i -> id.equals(courses.get(i).getId()))
                .findFirst();
        if (indexOpt.isEmpty()){
            throw new RuntimeException("Course not found");
        }
        this.courses.remove(indexOpt.getAsInt());
    }

}
