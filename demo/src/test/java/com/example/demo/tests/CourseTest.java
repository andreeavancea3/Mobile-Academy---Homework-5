package com.example.demo.tests;
import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CourseTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void testCourseCRUD() {

        Course course = new Course();
        course.setTitle("Math");
        course.setDescription("3 points");
        courseRepository.save(course);

        Course retrievedCourse = courseRepository.findById(course.getId()).orElse(null);

        assertNotNull(retrievedCourse);
        assertEquals("Math", retrievedCourse.getTitle());
        assertEquals("3 points", retrievedCourse.getDescription());
    }
}
