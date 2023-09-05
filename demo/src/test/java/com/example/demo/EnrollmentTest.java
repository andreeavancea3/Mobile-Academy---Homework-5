package com.example.demo;

import com.example.demo.model.Course;
import com.example.demo.model.Enrollment;
import com.example.demo.model.Student;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.EnrollmentRepository;
import com.example.demo.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EnrollmentTest {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private EnrollmentRepository enrollmentRepository;
    @Test
    public void testEnrollmentRelationships() {
        Course course = new Course();
        course.setTitle("Math");
        course.setDescription("3 points");
        courseRepository.save(course);

        Student student = new Student();
        student.setName("John");
        student.setEmail("john@gmail.com");
        studentRepository.save(student);

        Enrollment enrollment = new Enrollment();
        enrollment.setCourse(course);
        enrollment.setStudent(student);

        LocalDate localDate = LocalDate.now();
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        enrollment.setEnrollmentDate(date);

        enrollmentRepository.save(enrollment);

        Enrollment savedEnrollment = enrollmentRepository.findById(enrollment.getId()).orElse(null);
        assertNotNull(savedEnrollment);
        assertEquals(course.getId(), savedEnrollment.getCourse().getId());
        assertEquals(student.getId(), savedEnrollment.getStudent().getId());
    }
}
