package com.fon.college.service.mapper;

import com.fon.college.domain.*;
import com.fon.college.payload.*;
import org.springframework.stereotype.Service;

@Service
public class DtoMapper {

    public DepartmentDto mapToDepartmentDto(Department department) {
        DepartmentDto departmentDto = new DepartmentDto();

        departmentDto.setId(department.getId());

        if (department.getCurrentManager() != null) {
            departmentDto.setCurrentManagerId(department.getCurrentManager().getId());
        }

        if (department.getCurrentSecretary() != null) {
            departmentDto.setCurrentSecretaryId(department.getCurrentSecretary().getId());
        }

        departmentDto.setName(department.getName());
        departmentDto.setShortName(department.getShortName());

        return departmentDto;
    }

    public SubjectDto mapToSubjectDto(Subject subject) {
        SubjectDto subjectDto = new SubjectDto();

        subjectDto.setId(subject.getId());
        subjectDto.setDepartmentId(subject.getDepartment().getId());
        subjectDto.setName(subject.getName());
        subjectDto.setEspb(subject.getEspb());

        return subjectDto;
    }

    public MemberDto mapToMemberDto(Member member) {
        MemberDto memberDto = new MemberDto();

        memberDto.setId(member.getId());
        memberDto.setDepartmentId(member.getDepartment().getId());
        memberDto.setAcademicTitleId(member.getAcademicTitle().getId());
        memberDto.setEducationTitleId(member.getEducationTitle().getId());
        memberDto.setScientificFieldId(member.getScientificField().getId());
        memberDto.setFirstName(member.getFirstName());
        memberDto.setLastName(member.getLastName());

        return memberDto;
    }

    public AcademicTitleDto mapToAcademicTitleDto(AcademicTitle academicTitle) {
        AcademicTitleDto academicTitleDto = new AcademicTitleDto();

        academicTitleDto.setId(academicTitle.getId());
        academicTitleDto.setTitle(academicTitle.getTitle());

        return academicTitleDto;
    }

    public EducationTitleDto mapToEducationTitleDto(EducationTitle educationTitle) {
        EducationTitleDto educationTitleDto = new EducationTitleDto();

        educationTitleDto.setId(educationTitle.getId());
        educationTitleDto.setTitle(educationTitle.getTitle());

        return educationTitleDto;
    }

    public ScientificFieldDto mapToScientificFieldDto(ScientificField scientificField) {
        ScientificFieldDto scientificFieldDto = new ScientificFieldDto();

        scientificFieldDto.setId(scientificField.getId());
        scientificFieldDto.setField(scientificField.getField());

        return scientificFieldDto;
    }

    public AcademicTitleHistoryDto mapToAcademicTitleHistoryDto(AcademicTitleHistory academicTitleHistory) {
        AcademicTitleHistoryDto academicTitleHistoryDto = new AcademicTitleHistoryDto();

        academicTitleHistoryDto.setId(academicTitleHistory.getId());
        academicTitleHistoryDto.setMemberId(academicTitleHistory.getMember().getId());
        academicTitleHistoryDto.setAcademicTitleId(academicTitleHistory.getAcademicTitle().getId());
        academicTitleHistoryDto.setScientificFieldId(academicTitleHistory.getScientificField().getId());
        academicTitleHistoryDto.setStartDate(academicTitleHistory.getStartDate());
        academicTitleHistoryDto.setEndDate(academicTitleHistory.getEndDate());

        return academicTitleHistoryDto;
    }

    public DepartmentManagerHistoryDto mapToDepartmentManagerHistoryDto(DepartmentManagerHistory departmentManagerHistory) {
        DepartmentManagerHistoryDto departmentManagerHistoryDto = new DepartmentManagerHistoryDto();

        departmentManagerHistoryDto.setId(departmentManagerHistory.getId());
        departmentManagerHistoryDto.setDepartmentId(departmentManagerHistory.getDepartment().getId());
        departmentManagerHistoryDto.setManagerId(departmentManagerHistory.getManager().getId());
        departmentManagerHistoryDto.setStartDate(departmentManagerHistory.getStartDate());
        departmentManagerHistoryDto.setEndDate(departmentManagerHistory.getEndDate());

        return departmentManagerHistoryDto;
    }

    public DepartmentSecretaryHistoryDto mapToDepartmentSecretaryHistoryDto(DepartmentSecretaryHistory departmentSecretaryHistory) {
        DepartmentSecretaryHistoryDto departmentSecretaryHistoryDto = new DepartmentSecretaryHistoryDto();

        departmentSecretaryHistoryDto.setId(departmentSecretaryHistory.getId());
        departmentSecretaryHistoryDto.setDepartmentId(departmentSecretaryHistory.getDepartment().getId());
        departmentSecretaryHistoryDto.setSecretaryId(departmentSecretaryHistory.getSecretary().getId());
        departmentSecretaryHistoryDto.setStartDate(departmentSecretaryHistory.getStartDate());
        departmentSecretaryHistoryDto.setEndDate(departmentSecretaryHistory.getEndDate());

        return departmentSecretaryHistoryDto;
    }

}
