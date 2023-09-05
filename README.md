# Mobile-Academy---Homework-5
**Exercise Title: Building a Course Enrollment System**

**Objective:**
Develop a course enrollment system using Spring Boot and JPA. Create three classes (`Course`, `Student`, and `Enrollment`) with appropriate relationships, and implement JUnit tests to validate these relationships.

**Requirements:**

1. Create an entity class named `Course` with the following attributes:
– `id` (auto-generated)
– `title`
– `description`

2. Create an entity class named `Student` with the following attributes:
– `id` (auto-generated)
– `name`
– `email`

3. Create an entity class named `Enrollment` with the following attributes:
– `id`
– `course`
– `student`
– `enrollmentDate`

4. Define appropriate JPA annotations to establish the following relationships:
– A course can have multiple enrollments
– A student can have multiple enrollments

**Instructions:**
-create the endpoints necesary in order to create students, courses, enroll students on courses, and view all the students and the courses where they are enrolled
