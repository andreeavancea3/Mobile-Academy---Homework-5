package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.model.Enrollment;
import com.example.demo.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/course-enrollment")
public class EnrollmentController {
    @Autowired
    EnrollmentService enrollmentService;
    @GetMapping("/enrollments")
    public List<Enrollment> getAllEnrollments(){
        return enrollmentService.getAllEnrollments();
    }
    @PostMapping("/enroll")
    public ResponseEntity<Enrollment> enrollStudentOnCourse(@RequestBody Enrollment enrollment) {
        Enrollment enrolled = enrollmentService.enrollStudentsOnCourses(enrollment);
        return new ResponseEntity<>(enrolled, HttpStatus.CREATED);
    }
}
