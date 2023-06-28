package com.example.demo;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.repository.CourseRepo;
import com.example.demo.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@SpringBootApplication
public class DemoApplication implements ApplicationRunner {

	private final CourseRepo courseRepo;
	private final StudentRepo studentRepo;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	public void initTestData() {
		courseRepo.create(new Course(Long.valueOf(1), "Advanced Programming Languages", "505"));
		courseRepo.create(new Course(Long.valueOf(2), "Advanced Software Design", "525"));
		courseRepo.create(new Course(Long.valueOf(3), "Enterprise Applications", "544"));
		courseRepo.create(new Course(Long.valueOf(4), "Software Architecture", "590"));
		courseRepo.create(new Course(Long.valueOf(5), "Artificial Intelligence", "589"));
		courseRepo.create(new Course(Long.valueOf(6), "Machine Learning", "582"));
		courseRepo.create(new Course(Long.valueOf(7), "Web application Architecture", "545"));
		courseRepo.create(new Course(Long.valueOf(8), "Big Data", "522"));
		courseRepo.create(new Course(Long.valueOf(9), "Cloud Computing", "516"));

		studentRepo.create(new Student(Long.valueOf(1), "Anton",
				"Pavlov", "anton@miu.edu", "ComPro",
				courseRepo.findAll().stream().limit(4).collect(Collectors.toList())));

		studentRepo.create(new Student(Long.valueOf(2), "John",
				"Smith", "john@miu.edu", "ComPro",
				courseRepo.findAll().stream().skip(5).limit(4).collect(Collectors.toList())));

		studentRepo.create(new Student(Long.valueOf(3), "Abraham",
				"Ladaf", "abraham@miu.edu", "ComPro",
				courseRepo.findAll().stream().skip(3).limit(5).collect(Collectors.toList())));

	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		initTestData();
	}
}
