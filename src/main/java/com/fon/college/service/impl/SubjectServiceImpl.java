package com.fon.college.service.impl;

import com.fon.college.domain.Subject;
import com.fon.college.exception.ResourceNotFoundException;
import com.fon.college.payload.SubjectDto;
import com.fon.college.repository.SubjectRepository;
import com.fon.college.service.SubjectService;
import com.fon.college.service.mapper.DtoMapper;
import com.fon.college.service.mapper.EntityMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final EntityMapper entityMapper;
    private final DtoMapper dtoMapper;

    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(EntityMapper entityMapper,
                              DtoMapper dtoMapper,
                              SubjectRepository subjectRepository) {
        this.entityMapper = entityMapper;
        this.dtoMapper = dtoMapper;
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<SubjectDto> getAll() {
        List<Subject> subjects = subjectRepository.findAll();

        return subjects.stream().map(dtoMapper::mapToSubjectDto).toList();
    }

    @Override
    public List<SubjectDto> getAllByDepartmentId(long departmentId) {
        List<Subject> subjects = subjectRepository.findAllByDepartmentId(departmentId);

        return subjects.stream().map(dtoMapper::mapToSubjectDto).toList();
    }

    @Override
    public SubjectDto getById(long id) {
        Subject subject = subjectRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Subject", "id", String.valueOf(id)));

        return dtoMapper.mapToSubjectDto(subject);
    }

    @Override
    public SubjectDto create(SubjectDto subjectDto) {
        Subject subject = entityMapper.mapToSubjectEntity(subjectDto);

        Subject createdSubject = subjectRepository.save(subject);

        return dtoMapper.mapToSubjectDto(createdSubject);
    }

    @Override
    public SubjectDto update(long id, SubjectDto subjectDto) {
        Subject subject = subjectRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Subject", "id", String.valueOf(id)));

        subject.setName(subjectDto.getName());
        subject.setEspb(subjectDto.getEspb());

        Subject updatedSubject = subjectRepository.save(subject);

        return dtoMapper.mapToSubjectDto(updatedSubject);
    }

    @Override
    public void delete(long id) {
        Subject subject = subjectRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Subject", "id", String.valueOf(id)));

        subjectRepository.delete(subject);
    }
}
