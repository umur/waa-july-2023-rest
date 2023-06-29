package com.waa.demo.services.Impls;

import com.waa.demo.entities.Course;
import com.waa.demo.entities.Student;
import com.waa.demo.repositories.StudentRepo;
import com.waa.demo.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo repo;

    @Override
    public void create(Student student) {
        repo.add(student);

    }

    @Override
    public List<Student> findAll() {
        return repo.findAll();
    }

    @Override
    public Student getById(Long id) {
        return repo.getById(id);
    }

    @Override
    public void update(Long id, Student student) {
        repo.save(id,student);
    }

    @Override
    public void delete(Long id) {
        repo.delete(id);
    }

    @Override
    public List<Student> filterByMajor(String major) {
        return repo.findAllByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(Long id) {
        return repo.getCoursesByStudentId(id);
    }
}
