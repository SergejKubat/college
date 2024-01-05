package com.fon.college.service.impl;

import com.fon.college.domain.AcademicTitle;
import com.fon.college.exception.ResourceNotFoundException;
import com.fon.college.payload.AcademicTitleDto;
import com.fon.college.repository.AcademicTitleRepository;
import com.fon.college.service.AcademicTitleService;
import com.fon.college.service.mapper.DtoMapper;
import com.fon.college.service.mapper.EntityMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicTitleServiceImpl implements AcademicTitleService {

    private final EntityMapper entityMapper;
    private final DtoMapper dtoMapper;

    private final AcademicTitleRepository academicTitleRepository;

    public AcademicTitleServiceImpl(EntityMapper entityMapper,
                                    DtoMapper dtoMapper,
                                    AcademicTitleRepository academicTitleRepository) {
        this.entityMapper = entityMapper;
        this.dtoMapper = dtoMapper;
        this.academicTitleRepository = academicTitleRepository;
    }

    @Override
    public List<AcademicTitleDto> getAll() {
        List<AcademicTitle> academicTitles = academicTitleRepository.findAll();

        return academicTitles.stream().map(dtoMapper::mapToAcademicTitleDto).toList();
    }

    @Override
    public AcademicTitleDto getById(long id) {
        AcademicTitle academicTitle = academicTitleRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("AcademicTitle", "id", String.valueOf(id)));

        return dtoMapper.mapToAcademicTitleDto(academicTitle);
    }

    @Override
    public AcademicTitleDto create(AcademicTitleDto academicTitleDto) {
        AcademicTitle academicTitle = entityMapper.mapToAcademicTitleEntity(academicTitleDto);

        AcademicTitle createdAcademicTitle = academicTitleRepository.save(academicTitle);

        return dtoMapper.mapToAcademicTitleDto(createdAcademicTitle);
    }

    @Override
    public AcademicTitleDto update(long id, AcademicTitleDto academicTitleDto) {
        AcademicTitle academicTitle = academicTitleRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("AcademicTitle", "id", String.valueOf(id)));

        academicTitle.setTitle(academicTitleDto.getTitle());

        AcademicTitle updatedAcademicTitle = academicTitleRepository.save(academicTitle);

        return dtoMapper.mapToAcademicTitleDto(updatedAcademicTitle);
    }

    @Override
    public void delete(long id) {
        AcademicTitle academicTitle = academicTitleRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("AcademicTitle", "id", String.valueOf(id)));

        academicTitleRepository.delete(academicTitle);
    }
}
