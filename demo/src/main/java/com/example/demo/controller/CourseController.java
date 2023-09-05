package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/course-enrollment")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }
    @PostMapping("/createcourse")
    public Course createCourse(@RequestBody Course course){
        return courseService.createCourse(course);
    }
}
