package com.fon.college.repository;

import com.fon.college.domain.Department;
import com.fon.college.domain.Subject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class SubjectRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @BeforeEach
    void setUp() {
        Department testDepartment = new Department(
                null, "Department 1", "Dept 1");

        Subject testSubject = new Subject(
                null, "Subject 1", 6, testDepartment);

        departmentRepository.save(testDepartment);
        subjectRepository.save(testSubject);
    }

    @AfterEach
    void tearDown() {
        subjectRepository.deleteAll();
        departmentRepository.deleteAll();
    }

    @Test
    @DisplayName("Find all subjects by department id - not empty.")
    void selectByDepartmentIdTestingFound() {
        List<Subject> subjects = subjectRepository.findAllByDepartmentId(1L);

        assertTrue(subjects.isEmpty());
    }

    @Test
    @DisplayName("Find subjects by department id - empty.")
    void selectByDepartmentIdTestingNotFound() {
        List<Subject> subjects = subjectRepository.findAllByDepartmentId(10L);

        assertTrue(subjects.isEmpty());
    }
}
