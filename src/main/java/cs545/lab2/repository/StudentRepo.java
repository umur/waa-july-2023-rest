package cs545.lab2.repository;

import cs545.lab2.entity.Course;
import cs545.lab2.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
    static List<Student> students=new ArrayList<>();

    public boolean save(Student student){
        students.add(student);
        return true;
    }
    public List<Student> findAll() {
        return students;
    }
    public Student findById(int id){
        for(Student student:students){
            if(id==student.getId())
                return student;
        }
        return null;
    }
    public void update(int id,Student student){

        if(id==student.getId())
            student.setEmail(student.getEmail());
            student.setCourseTaken(student.getCourseTaken());
            student.setMajor(student.getMajor());
            student.setFirstName(student.getFirstName());
            student.setLastName(student.getLastName());
    students.add(student);
    }

    public void deleteById(int id){
        for (Student student:students){
            if(id==student.getId())
                students.remove(student);
        }
    }

   public List<Student> getStudentsByMajor(String major) {
       for (Student student : students) {
           if (major.equals(student.getMajor()))
               return students;
       }
       return null;
   }
}
