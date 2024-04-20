package com.fon.college.service;

import com.fon.college.domain.*;
import com.fon.college.exception.ResourceNotFoundException;
import com.fon.college.payload.MemberDto;
import com.fon.college.repository.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class MemberServiceTest {
    @Autowired
    private MemberService memberService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @MockBean
    private AcademicTitleRepository academicTitleRepository;

    @MockBean
    private EducationTitleRepository educationTitleRepository;

    @MockBean
    private ScientificFieldRepository scientificFieldRepository;

    @MockBean
    private AcademicTitleHistoryRepository academicTitleHistoryRepository;

    @MockBean
    private MemberRepository memberRepository;

    private final Department department = new Department(1L, "Department 1", "Dept 1");

    private final AcademicTitle academicTitle = new AcademicTitle(1L, "Academic title 1");

    private final EducationTitle educationTitle = new EducationTitle(1L, "Education title 1");

    private final ScientificField scientificField = new ScientificField(1L, "Scientific field 1");

    @Test
    @DisplayName("Get all members")
    void getAllMembersTest() {
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

    @Test
    @DisplayName("Get member by id")
    void getMemberByIdTest() {
        long memberId = 1L;

        Member member = new Member(1L, "John", "Doe", department, academicTitle, educationTitle,
                scientificField);

        when(memberRepository.findById(memberId)).thenReturn(Optional.of(member));

        MemberDto memberDto = memberService.getById(memberId);

        assertNotNull(memberDto);
    }

    @Test
    @DisplayName("Get member by id - failure")
    void getMemberByIdFailureTest() {
        long memberId = 1L;

        assertThrows(ResourceNotFoundException.class, () -> {
            memberService.getById(memberId);
        });
    }

    @Test
    @DisplayName("Create member")
    void createMemberTest() {
        MemberDto memberDto = new MemberDto();

        memberDto.setDepartmentId(1L);
        memberDto.setAcademicTitleId(1L);
        memberDto.setEducationTitleId(1L);
        memberDto.setScientificFieldId(1L);

        Member member = new Member(1L, "John", "Doe", department, academicTitle, educationTitle,
                scientificField);

        AcademicTitleHistory academicTitleHistory = new AcademicTitleHistory(null, member, academicTitle,
                scientificField, new Date(), null);

        when(memberRepository.save(any(Member.class))).thenReturn(member);

        when(departmentRepository.findById(1L)).thenReturn(Optional.of(department));
        when(academicTitleRepository.findById(1L)).thenReturn(Optional.of(academicTitle));
        when(educationTitleRepository.findById(1L)).thenReturn(Optional.of(educationTitle));
        when(scientificFieldRepository.findById(1L)).thenReturn(Optional.of(scientificField));

        when(academicTitleHistoryRepository.save(any(AcademicTitleHistory.class))).thenReturn(academicTitleHistory);

        MemberDto createdMemberDto = memberService.create(memberDto);

        assertNotNull(createdMemberDto);
    }

    @Test
    @DisplayName("Create member - failure")
    void createMemberFailureTest() {
        MemberDto memberDto = new MemberDto();

        memberDto.setDepartmentId(1L);
        memberDto.setAcademicTitleId(1L);
        memberDto.setEducationTitleId(1L);
        memberDto.setScientificFieldId(1L);

        Member member = new Member(1L, "John", "Doe", department, academicTitle, educationTitle,
                scientificField);

        assertThrows(ResourceNotFoundException.class, () -> {
            memberService.create(memberDto);
        });
    }

    @Test
    @DisplayName("Update member")
    void updateMemberTest() {
        long memberId = 1L;

        MemberDto memberDto = new MemberDto();

        memberDto.setDepartmentId(1L);
        memberDto.setAcademicTitleId(1L);
        memberDto.setEducationTitleId(1L);
        memberDto.setScientificFieldId(1L);

        Member member = new Member(1L, "John", "Doe", department, academicTitle, educationTitle,
                scientificField);

        when(memberRepository.findById(memberId)).thenReturn(Optional.of(member));

        when(departmentRepository.findById(1L)).thenReturn(Optional.of(department));
        when(academicTitleRepository.findById(1L)).thenReturn(Optional.of(academicTitle));
        when(educationTitleRepository.findById(1L)).thenReturn(Optional.of(educationTitle));
        when(scientificFieldRepository.findById(1L)).thenReturn(Optional.of(scientificField));

        when(memberRepository.save(any(Member.class))).thenReturn(member);

        MemberDto updatedMemberDto = memberService.update(memberId, memberDto);

        assertNotNull(updatedMemberDto);
    }

    @Test
    @DisplayName("Update member - failure")
    void updateMemberFailureTest() {
        long memberId = 1L;

        MemberDto memberDto = new MemberDto();

        memberDto.setDepartmentId(1L);
        memberDto.setAcademicTitleId(1L);
        memberDto.setEducationTitleId(1L);
        memberDto.setScientificFieldId(1L);

        assertThrows(ResourceNotFoundException.class, () -> {
            memberService.update(memberId, memberDto);
        });
    }

    @Test
    @DisplayName("Delete member")
    void deleteMemberTest() {
        long memberId = 1L;

        Member member = new Member(1L, "John", "Doe", department, academicTitle, educationTitle,
                scientificField);

        when(memberRepository.findById(memberId)).thenReturn(Optional.of(member));

        memberService.delete(memberId);

        verify(memberRepository, times(1)).delete(member);
    }

    @Test
    @DisplayName("Delete member - failure")
    void deleteMemberFailureTest() {
        long memberId = 1L;

        assertThrows(ResourceNotFoundException.class, () -> {
            memberService.delete(memberId);
        });
    }
}
