package com.fon.college.service;

import com.fon.college.payload.ScientificFieldDto;

import java.util.List;

public interface ScientificFieldService {
    List<ScientificFieldDto> getAll();

    ScientificFieldDto getById(long id);

    ScientificFieldDto create(ScientificFieldDto scientificFieldDto);

    ScientificFieldDto update(long id, ScientificFieldDto scientificFieldDto);

    void delete(long id);
}
