package com.fon.college.service.impl;

import com.fon.college.domain.ScientificField;
import com.fon.college.exception.ResourceNotFoundException;
import com.fon.college.payload.ScientificFieldDto;
import com.fon.college.repository.ScientificFieldRepository;
import com.fon.college.service.ScientificFieldService;
import com.fon.college.service.mapper.DtoMapper;
import com.fon.college.service.mapper.EntityMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScientificFieldServiceImpl implements ScientificFieldService {

    private final EntityMapper entityMapper;
    private final DtoMapper dtoMapper;

    private final ScientificFieldRepository scientificFieldRepository;

    public ScientificFieldServiceImpl(EntityMapper entityMapper,
                                      DtoMapper dtoMapper,
                                      ScientificFieldRepository scientificFieldRepository) {
        this.entityMapper = entityMapper;
        this.dtoMapper = dtoMapper;
        this.scientificFieldRepository = scientificFieldRepository;
    }

    @Override
    public List<ScientificFieldDto> getAll() {
        List<ScientificField> scientificFields = scientificFieldRepository.findAll();

        return scientificFields.stream().map(dtoMapper::mapToScientificFieldDto).toList();
    }

    @Override
    public ScientificFieldDto getById(long id) {
        ScientificField scientificField = scientificFieldRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("ScientificField", "id", String.valueOf(id)));

        return dtoMapper.mapToScientificFieldDto(scientificField);
    }

    @Override
    public ScientificFieldDto create(ScientificFieldDto scientificFieldDto) {
        ScientificField scientificField = entityMapper.mapToScientificFieldEntity(scientificFieldDto);

        ScientificField createdScientificField = scientificFieldRepository.save(scientificField);

        return dtoMapper.mapToScientificFieldDto(createdScientificField);
    }

    @Override
    public ScientificFieldDto update(long id, ScientificFieldDto scientificFieldDto) {
        ScientificField scientificField = scientificFieldRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("ScientificField", "id", String.valueOf(id)));

        scientificField.setField(scientificFieldDto.getField());

        ScientificField updatedScientificField = scientificFieldRepository.save(scientificField);

        return dtoMapper.mapToScientificFieldDto(updatedScientificField);
    }

    @Override
    public void delete(long id) {
        ScientificField scientificField = scientificFieldRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("ScientificField", "id", String.valueOf(id)));

        scientificFieldRepository.delete(scientificField);
    }
}
