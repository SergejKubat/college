package com.fon.college.service;

import com.fon.college.payload.EducationTitleDto;

import java.util.List;

public interface EducationTitleService {
    List<EducationTitleDto> getAll();

    EducationTitleDto getById(long id);

    EducationTitleDto create(EducationTitleDto educationTitleDto);

    EducationTitleDto update(long id, EducationTitleDto educationTitleDto);

    void delete(long id);
}
