package lab2.Repository;

import lab2.Model.Course;
import lab2.Model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

@Repository
public class StudentRepo {
    private static int currentId = 1;
    private static List<Student> students = new ArrayList<>();

    public List<Student> getAll(){
        return students;
    }
    public Student getRecordById(Long id){
        Optional<Student> student  = students.stream().filter(s -> s.getId().equals(id)).findAny();
        if (student.isEmpty()){
            throw new RuntimeException("Course not found");
        }
        return student.get();
    }

    public void create(Student student){
        student.setId(Long.valueOf(currentId++));
        students.add(student);
    }
    public Student update(Long id,Student student){
        OptionalInt indexOpt = IntStream.range(0, students.size())
                .filter(i -> id.equals(students.get(i).getId()))
                .findFirst();
        if (indexOpt.isEmpty()){
            throw new RuntimeException("Course not found");
        }
        Student targetStudent = students.get(indexOpt.getAsInt());
        student.setId(targetStudent.getId());
        students.set(indexOpt.getAsInt(), student);
        return students.get(indexOpt.getAsInt());
    }
    public void delete (Long id){
        OptionalInt indexOpt = IntStream.range(0, students.size())
                .filter(i -> id.equals(students.get(i).getId()))
                .findFirst();
        if (indexOpt.isEmpty()){
            throw new RuntimeException("Course not found");
        }
        students.remove(indexOpt.getAsInt());
    }
    public List<Student> getStudentsByMajor(String major){
        return students.stream().filter(student -> student.getMajor().equals(major)).toList();
    }

    public void addCourseToStudent(Long studentId, Course course){
        OptionalInt indexOpt = IntStream.range(0, students.size())
                .filter(i -> studentId.equals(students.get(i).getId()))
                .findFirst();
        if (indexOpt.isEmpty()){
            throw new RuntimeException("Course not found");
        }
        students.get(indexOpt.getAsInt()).getCoursesTaken().add(course);
    }

    public List<Course> getCoursesByStudentId(Long id){
        OptionalInt indexOpt = IntStream.range(0, students.size())
                .filter(i -> id.equals(students.get(i).getId()))
                .findFirst();
        if (indexOpt.isEmpty()){
            throw new RuntimeException("Course not found");
        }
        return students.get(indexOpt.getAsInt()).getCoursesTaken();
    }

}
