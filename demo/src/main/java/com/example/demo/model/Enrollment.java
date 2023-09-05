package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    private Date enrollmentDate;
}

/*
– A course can have multiple enrollments
– A student can have multiple enrollments
 */