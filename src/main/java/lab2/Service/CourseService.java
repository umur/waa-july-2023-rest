package lab2.Service;

import lab2.Model.Course;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CourseService {

    public List<Course> getAll();
    public Course getRecordById(Long id);
    public void create(Course course);
    public void update(Long id,Course course);
    public void delete (Long id);
}
