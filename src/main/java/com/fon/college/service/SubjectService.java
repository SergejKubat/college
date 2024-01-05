package com.fon.college.service;

import com.fon.college.payload.SubjectDto;

import java.util.List;

public interface SubjectService {
    List<SubjectDto> getAll();

    List<SubjectDto> getAllByDepartmentId(long departmentId);

    SubjectDto getById(long id);

    SubjectDto create(SubjectDto subjectDto);

    SubjectDto update(long id, SubjectDto subjectDto);

    void delete(long id);
}
