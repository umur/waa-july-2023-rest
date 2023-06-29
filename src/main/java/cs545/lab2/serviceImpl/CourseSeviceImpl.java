package cs545.lab2.serviceImpl;

import cs545.lab2.entity.Course;
import cs545.lab2.entity.Student;
import cs545.lab2.repository.CourseRepo;
import cs545.lab2.service.CourseService;
import cs545.lab2.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseSeviceImpl implements CourseService {
    private final CourseRepo courseRepo;
    public void addCourse(Course course){
        courseRepo.save(course);
    }

    public List<Course> getAllCourses(Course course){
        return courseRepo.findAll(course);
    }

    public Course getCourseById(Long id){
        return courseRepo.findById(id);
    }

    public void deleteCourseById(Long id){
        courseRepo.findById(id);
    }

    public void updateCourse(Long id, Course course){
        courseRepo.update(id,course);
    }

    public List<Course> getCoursesByStudentId(Integer studentId){

        return courseRepo.getCoursesByStudentId(studentId);
    }
}
