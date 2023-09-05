package com.example.demo.tests;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testStudentCRUD() {
        Student student = new Student();
        student.setName("John");
        student.setEmail("john@gmail.com");
        studentRepository.save(student);

        Student retrievedStudent = studentRepository.findById(student.getId()).orElse(null);

        assertNotNull(retrievedStudent);
        assertEquals("John", retrievedStudent.getName());
        assertEquals("john@gmail.com", retrievedStudent.getEmail());
    }
}



