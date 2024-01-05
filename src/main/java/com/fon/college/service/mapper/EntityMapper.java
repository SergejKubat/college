package com.fon.college.service.mapper;

import com.fon.college.domain.*;
import com.fon.college.payload.*;
import org.springframework.stereotype.Service;

@Service
public class EntityMapper {
    public Department mapToDepartmentEntity(DepartmentDto departmentDto) {
        Department department = new Department();

        department.setName(departmentDto.getName());
        department.setShortName(departmentDto.getShortName());

        return department;
    }

    public Subject mapToSubjectEntity(SubjectDto subjectDto) {
        Subject subject = new Subject();

        subject.setName(subjectDto.getName());
        subject.setEspb(subjectDto.getEspb());

        return subject;
    }

    public Member mapToMemberEntity(MemberDto memberDto) {
        Member member = new Member();

        member.setFirstName(memberDto.getFirstName());
        member.setLastName(memberDto.getLastName());

        return member;
    }

    public AcademicTitle mapToAcademicTitleEntity(AcademicTitleDto academicTitleDto) {
        AcademicTitle academicTitle = new AcademicTitle();

        academicTitle.setTitle(academicTitleDto.getTitle());

        return academicTitle;
    }

    public EducationTitle mapToEducationTitleEntity(EducationTitleDto educationTitleDto) {
        EducationTitle educationTitle = new EducationTitle();

        educationTitle.setTitle(educationTitleDto.getTitle());

        return educationTitle;
    }

    public ScientificField mapToScientificFieldEntity(ScientificFieldDto scientificFieldDto) {
        ScientificField scientificField = new ScientificField();

        scientificField.setField(scientificFieldDto.getField());

        return scientificField;
    }

    public AcademicTitleHistory mapToAcademicTitleHistoryEntity(AcademicTitleHistoryDto academicTitleHistoryDto) {
        AcademicTitleHistory academicTitleHistory = new AcademicTitleHistory();

        academicTitleHistory.setStartDate(academicTitleHistoryDto.getStartDate());
        academicTitleHistory.setEndDate(academicTitleHistoryDto.getEndDate());

        return academicTitleHistory;
    }

    public DepartmentManagerHistory mapToDepartmentManagerHistoryEntity(DepartmentManagerHistoryDto departmentManagerHistoryDto) {
        DepartmentManagerHistory departmentManagerHistory = new DepartmentManagerHistory();

        departmentManagerHistory.setStartDate(departmentManagerHistoryDto.getStartDate());
        departmentManagerHistory.setEndDate(departmentManagerHistoryDto.getEndDate());

        return departmentManagerHistory;
    }

    public DepartmentSecretaryHistory mapToDepartmentSecretaryHistoryEntity(DepartmentSecretaryHistoryDto departmentSecretaryHistoryDto) {
        DepartmentSecretaryHistory departmentSecretaryHistory = new DepartmentSecretaryHistory();

        departmentSecretaryHistory.setStartDate(departmentSecretaryHistoryDto.getStartDate());
        departmentSecretaryHistory.setEndDate(departmentSecretaryHistoryDto.getEndDate());

        return departmentSecretaryHistory;
    }
}
