package com.fon.college.service.impl;

import com.fon.college.payload.SubjectDto;
import com.fon.college.service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Override
    public List<SubjectDto> getAll() {
        return null;
    }

    @Override
    public List<SubjectDto> getAllByDepartmentId(long departmentId) {
        return null;
    }

    @Override
    public SubjectDto getById(long id) {
        return null;
    }

    @Override
    public SubjectDto create(SubjectDto subjectDto) {
        return null;
    }

    @Override
    public SubjectDto update(long id, SubjectDto subjectDto) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
