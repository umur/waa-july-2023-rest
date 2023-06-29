package waa.restapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import waa.restapp.domain.Course;
import waa.restapp.repository.CourseRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;

    @Override
    public Course create(Course course) {
        if (course.getName().length() < 3  || course.getCode().length() < 3) throw new RuntimeException("Course name and code must be greater than 3 chars");
        if (course.getId() < 0) throw new RuntimeException("Course ID must be an integer");
        return courseRepository.create(course);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(Integer id) {
        return courseRepository.findById(id);
    }

    @Override
    public Course update(Integer id, Course course) {
        return courseRepository.update(id, course);
    }

    @Override
    public void delete(Integer id) {
        courseRepository.delete(id);
    }
}
