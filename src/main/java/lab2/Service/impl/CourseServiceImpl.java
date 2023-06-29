package lab2.Service.impl;

import lab2.Model.Course;
import lab2.Repository.CourseRepo;
import lab2.Repository.StudentRepo;
import lab2.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;

    @Autowired
    public CourseServiceImpl(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    public List<Course> getAll() {
        return this.courseRepo.getAll();
    }

    public Course getRecordById(Long id) {
        return this.courseRepo.getRecordById(id);
    }

    public void create(Course course) {
        if (course.getName().equals("")) {
            throw new RuntimeException("Course name is required");
        }
        if (course.getCode().equals("")) {
            throw new RuntimeException("Course code is required");
        }
        this.courseRepo.create(course);
    }

    public void update(Long id, Course course) {
        if (course.getName().equals("")) {
            throw new RuntimeException("Course name is required");
        }
        if (course.getCode().equals("")) {
            throw new RuntimeException("Course code is required");
        }
        this.courseRepo.update(id, course);
    }

    public void delete(Long id) {
        this.courseRepo.delete(id);
    }
}
