package com.fon.college.service;

import com.fon.college.payload.AcademicTitleDto;

import java.util.List;

public interface AcademicTitleService {
    List<AcademicTitleDto> getAll();

    AcademicTitleDto getById(long id);

    AcademicTitleDto create(AcademicTitleDto academicTitleDto);

    AcademicTitleDto update(long id, AcademicTitleDto academicTitleDto);

    void delete(long id);
}
