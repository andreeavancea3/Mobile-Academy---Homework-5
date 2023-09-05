package com.example.demo.service;

import com.example.demo.model.Course;
import com.example.demo.model.Enrollment;
import com.example.demo.model.Student;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.EnrollmentRepository;
import com.example.demo.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EnrollmentService {
    @Autowired
    EnrollmentRepository enrollmentRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseRepository courseRepository;
    public Enrollment enrollStudentsOnCourses(Enrollment enrollment) {
        Student student = studentRepository.findById(enrollment.getStudent().getId())
                .orElseThrow(()->new EntityNotFoundException("Student not found!"));
        Course course= courseRepository.findById(enrollment.getCourse().getId())
                .orElseThrow(()-> new EntityNotFoundException("Course not found!"));
        Enrollment newEnrollment = new Enrollment();
        newEnrollment.setStudent(student);
        newEnrollment.setCourse(course);
        newEnrollment.setEnrollmentDate(new Date());

        return enrollmentRepository.save(enrollment);
    }
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

}
