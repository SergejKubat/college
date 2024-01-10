package com.fon.college.service.impl;

import com.fon.college.domain.*;
import com.fon.college.exception.ResourceNotFoundException;
import com.fon.college.payload.MemberDto;
import com.fon.college.repository.*;
import com.fon.college.service.MemberService;
import com.fon.college.service.mapper.DtoMapper;
import com.fon.college.service.mapper.EntityMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final EntityMapper entityMapper;
    private final DtoMapper dtoMapper;

    private final MemberRepository memberRepository;
    private final DepartmentRepository departmentRepository;
    private final AcademicTitleRepository academicTitleRepository;
    private final EducationTitleRepository educationTitleRepository;
    private final ScientificFieldRepository scientificFieldRepository;
    private final AcademicTitleHistoryRepository academicTitleHistoryRepository;

    public MemberServiceImpl(EntityMapper entityMapper,
                             DtoMapper dtoMapper,
                             MemberRepository memberRepository,
                             DepartmentRepository departmentRepository,
                             AcademicTitleRepository academicTitleRepository,
                             EducationTitleRepository educationTitleRepository,
                             ScientificFieldRepository scientificFieldRepository,
                             AcademicTitleHistoryRepository academicTitleHistoryRepository) {
        this.entityMapper = entityMapper;
        this.dtoMapper = dtoMapper;
        this.memberRepository = memberRepository;
        this.departmentRepository = departmentRepository;
        this.academicTitleRepository = academicTitleRepository;
        this.educationTitleRepository = educationTitleRepository;
        this.scientificFieldRepository = scientificFieldRepository;
        this.academicTitleHistoryRepository = academicTitleHistoryRepository;
    }

    @Override
    public List<MemberDto> getAll() {
        List<Member> members = memberRepository.findAll();

        return members.stream().map(dtoMapper::mapToMemberDto).toList();
    }

    @Override
    public List<MemberDto> getAllByDepartmentId(long departmentId) {
        List<Member> members = memberRepository.findAllByDepartmentId(departmentId);

        return members.stream().map(dtoMapper::mapToMemberDto).toList();
    }

    @Override
    public MemberDto getById(long id) {
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Member", "id", String.valueOf(id)));

        return dtoMapper.mapToMemberDto(member);
    }

    @Override
    public MemberDto create(MemberDto memberDto) {
        Member member = entityMapper.mapToMemberEntity(memberDto);

        Department department = departmentRepository.findById(memberDto.getDepartmentId()).orElseThrow(
                () -> new ResourceNotFoundException("Department", "id", String.valueOf(memberDto.getDepartmentId())));
        AcademicTitle academicTitle = academicTitleRepository.findById(memberDto.getAcademicTitleId()).orElseThrow(
                () -> new ResourceNotFoundException("AcademicTitle", "id", String.valueOf(memberDto.getAcademicTitleId())));
        EducationTitle educationTitle = educationTitleRepository.findById(memberDto.getEducationTitleId()).orElseThrow(
                () -> new ResourceNotFoundException("EducationTitle", "id", String.valueOf(memberDto.getEducationTitleId())));
        ScientificField scientificField = scientificFieldRepository.findById(memberDto.getScientificFieldId()).orElseThrow(
                () -> new ResourceNotFoundException("ScientificField", "id", String.valueOf(memberDto.getScientificFieldId())));

        member.setDepartment(department);
        member.setAcademicTitle(academicTitle);
        member.setEducationTitle(educationTitle);
        member.setScientificField(scientificField);

        Member createdMember = memberRepository.save(member);

        // create new academic title history entry
        AcademicTitleHistory academicTitleHistory = new AcademicTitleHistory(null, createdMember, academicTitle,
                scientificField, new Date(), null);

        academicTitleHistoryRepository.save(academicTitleHistory);

        return dtoMapper.mapToMemberDto(createdMember);
    }

    @Override
    public MemberDto update(long id, MemberDto memberDto) {
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Member", "id", String.valueOf(id)));

        long currentAcademicTitleId = member.getAcademicTitle().getId();
        long newAcademicTitle = memberDto.getAcademicTitleId();

        boolean isAcademicTitleChanged = currentAcademicTitleId != newAcademicTitle;

        Department department = departmentRepository.findById(memberDto.getDepartmentId()).orElseThrow(
                () -> new ResourceNotFoundException("Department", "id", String.valueOf(memberDto.getDepartmentId())));
        AcademicTitle academicTitle = academicTitleRepository.findById(memberDto.getAcademicTitleId()).orElseThrow(
                () -> new ResourceNotFoundException("AcademicTitle", "id", String.valueOf(memberDto.getAcademicTitleId())));
        EducationTitle educationTitle = educationTitleRepository.findById(memberDto.getEducationTitleId()).orElseThrow(
                () -> new ResourceNotFoundException("EducationTitle", "id", String.valueOf(memberDto.getEducationTitleId())));
        ScientificField scientificField = scientificFieldRepository.findById(memberDto.getScientificFieldId()).orElseThrow(
                () -> new ResourceNotFoundException("ScientificField", "id", String.valueOf(memberDto.getScientificFieldId())));

        member.setFirstName(memberDto.getFirstName());
        member.setLastName(memberDto.getLastName());
        member.setDepartment(department);
        member.setAcademicTitle(academicTitle);
        member.setEducationTitle(educationTitle);
        member.setScientificField(scientificField);

        Member updatedMember = memberRepository.save(member);

        // if academic title is changed, create new academic title history entry and update old
        if (isAcademicTitleChanged) {
            AcademicTitleHistory oldAcademicTitleHistory = academicTitleHistoryRepository.findPreviousEntry(member.getId());

            oldAcademicTitleHistory.setEndDate(new Date());

            academicTitleHistoryRepository.save(oldAcademicTitleHistory);

            AcademicTitleHistory newAcademicTitleHistory = new AcademicTitleHistory(null, updatedMember, academicTitle,
                    scientificField, new Date(), null);

            academicTitleHistoryRepository.save(newAcademicTitleHistory);
        }

        return dtoMapper.mapToMemberDto(updatedMember);
    }

    @Override
    public void delete(long id) {
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Member", "id", String.valueOf(id)));

        memberRepository.delete(member);
    }
}
