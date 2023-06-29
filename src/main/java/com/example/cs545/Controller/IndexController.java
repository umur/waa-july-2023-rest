package com.example.cs545.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class IndexController {
    @GetMapping("/welcome")

    public String index(){
        return "index";
    }

    @GetMapping("/addCourse")
    public String addCourseForm(){
        return  "AddCourse";
    }
    @GetMapping("/addStudent")
    public String addStudentForm(){
        return "AddStudent";
    }

    @GetMapping("/allCourses")
    public String allCourses(){
        return "Course";
    }

    @GetMapping("/updateCourse")
    public String updateCourse(){
        return "UpdateCourse";
    }

    @GetMapping("/updateStudent")
    public String updateStudent(){
        return "UpdateStudent";
    }
}
