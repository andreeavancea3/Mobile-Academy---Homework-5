package com.example.demo.service;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }
    public Course createCourse(Course course){
        return courseRepository.save(course);
    }
}
