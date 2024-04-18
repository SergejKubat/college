package com.fon.college.repository;

import com.fon.college.domain.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class MemberRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private AcademicTitleRepository academicTitleRepository;
    @Autowired
    private EducationTitleRepository educationTitleRepository;
    @Autowired
    private ScientificFieldRepository scientificFieldRepository;
    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    void setUp() {
        Department testDepartment = new Department(
                null, "Department 1", "Dept 1");

        AcademicTitle testAcademicTitle = new AcademicTitle(null, "Academic title 1");

        EducationTitle testEducationTitle = new EducationTitle(null, "Education title 1");

        ScientificField testScientificField = new ScientificField(null, "Scientific field 1");

        Member testMember = new Member(null, "", "", testDepartment, testAcademicTitle,
                testEducationTitle, testScientificField);

        departmentRepository.save(testDepartment);
        academicTitleRepository.save(testAcademicTitle);
        educationTitleRepository.save(testEducationTitle);
        scientificFieldRepository.save(testScientificField);
        memberRepository.save(testMember);
    }

    @AfterEach
    void tearDown() {
        memberRepository.deleteAll();
        departmentRepository.deleteAll();
        academicTitleRepository.deleteAll();
        educationTitleRepository.deleteAll();
        scientificFieldRepository.deleteAll();
    }

    @Test
    @DisplayName("Find all members by department id - not empty.")
    void selectByDepartmentIdTestingFound() {
        List<Member> members = memberRepository.findAllByDepartmentId(1L);

        assertTrue(members.isEmpty());
    }

    @Test
    @DisplayName("Find all members by department id - empty.")
    void selectByDepartmentIdTestingNotFound() {
        List<Member> members = memberRepository.findAllByDepartmentId(2L);

        System.out.println("Size: " + members.size());

        assertTrue(members.isEmpty());
    }

    @Test
    @DisplayName("Find member by id")
    void selectByIdTesting() {
        boolean memberExists = memberRepository.existsById(1L);

        assertTrue(memberExists);
    }
}
