package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/course-enrollment")
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @PostMapping("/createstudent")
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }
}
