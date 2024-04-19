package com.fon.college.service;

import com.fon.college.domain.*;
import com.fon.college.payload.MemberDto;
import com.fon.college.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MemberServiceTest {
    @Autowired
    private MemberService memberService;

    @MockBean
    private MemberRepository memberRepository;

    @Test
    @DisplayName("Get all members")
    void getAllMembersTest() {
        Department department = new Department(
                1L, "Department 1", "Dept 1");

        AcademicTitle academicTitle = new AcademicTitle(1L, "Academic title 1");

        EducationTitle educationTitle = new EducationTitle(1L, "Education title 1");

        ScientificField scientificField = new ScientificField(1L, "Scientific field 1");

        List<Member> members = Arrays.asList(
                new Member(1L, "John", "Doe", department, academicTitle, educationTitle,
                        scientificField),
                new Member(2L, "Dylan", "Johnson", department, academicTitle, educationTitle,
                        scientificField)
        );

        when(memberRepository.findAll()).thenReturn(members);

        List<MemberDto> memberDtoList = memberService.getAll();

        assertEquals(members.size(), memberDtoList.size());
    }
}
