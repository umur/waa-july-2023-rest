package online.moumini.lab2.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import online.moumini.lab2.model.Course;

@Repository
public class CourseRepository {
    private List<Course> courses;

    public CourseRepository() {
        this.courses = new ArrayList<>();
        initializeDummyData();
    }

    private void initializeDummyData() {
        Course course1 = new Course();
        course1.setId(1);
        course1.setName("Course 1");
        course1.setCode("C1");

        Course course2 = new Course();
        course2.setId(2);
        course2.setName("Course 2");
        course2.setCode("C2");

        Course course3 = new Course();
        course3.setId(3);
        course3.setName("Course 3");
        course3.setCode("C3");

        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
    }

    public List<Course> getAllCourses() {
        return courses;
    }

    public Course getCourseById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    public Course saveCourse(Course course) {
        courses.add(course);
        return course;
    }

    public boolean deleteCourseById(int id) {
        Course courseToDelete = getCourseById(id);
        if (courseToDelete != null) {
            return courses.remove(courseToDelete);
        }
        return false;
    }

    /*
     * public List<Course> getCoursesByStudentId(int studentId) {
     * List<Course> coursesByStudentId = new ArrayList<>();
     * for (Course course : courses) {
     * if (course.getStudents().contains(studentId)) {
     * coursesByStudentId.add(course);
     * }
     * }
     * return coursesByStudentId;
     * }
     */
}
