package com.fon.college.service.impl;

import com.fon.college.domain.EducationTitle;
import com.fon.college.exception.ResourceNotFoundException;
import com.fon.college.payload.EducationTitleDto;
import com.fon.college.repository.EducationTitleRepository;
import com.fon.college.service.EducationTitleService;
import com.fon.college.service.mapper.DtoMapper;
import com.fon.college.service.mapper.EntityMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationTitleServiceImpl implements EducationTitleService {

    private final EntityMapper entityMapper;
    private final DtoMapper dtoMapper;

    private final EducationTitleRepository educationTitleRepository;

    public EducationTitleServiceImpl(EntityMapper entityMapper,
                                     DtoMapper dtoMapper,
                                     EducationTitleRepository educationTitleRepository) {
        this.entityMapper = entityMapper;
        this.dtoMapper = dtoMapper;
        this.educationTitleRepository = educationTitleRepository;
    }

    @Override
    public List<EducationTitleDto> getAll() {
        List<EducationTitle> educationTitles = educationTitleRepository.findAll();

        return educationTitles.stream().map(dtoMapper::mapToEducationTitleDto).toList();
    }

    @Override
    public EducationTitleDto getById(long id) {
        EducationTitle educationTitle = educationTitleRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("EducationTitle", "id", String.valueOf(id)));

        return dtoMapper.mapToEducationTitleDto(educationTitle);
    }

    @Override
    public EducationTitleDto create(EducationTitleDto educationTitleDto) {
        EducationTitle educationTitle = entityMapper.mapToEducationTitleEntity(educationTitleDto);

        EducationTitle createdEducationTitle = educationTitleRepository.save(educationTitle);

        return dtoMapper.mapToEducationTitleDto(createdEducationTitle);
    }

    @Override
    public EducationTitleDto update(long id, EducationTitleDto educationTitleDto) {
        EducationTitle educationTitle = educationTitleRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("EducationTitle", "id", String.valueOf(id)));

        educationTitle.setTitle(educationTitleDto.getTitle());

        EducationTitle updatedEducationTitle = educationTitleRepository.save(educationTitle);

        return dtoMapper.mapToEducationTitleDto(updatedEducationTitle);
    }

    @Override
    public void delete(long id) {
        EducationTitle educationTitle = educationTitleRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("EducationTitle", "id", String.valueOf(id)));

        educationTitleRepository.delete(educationTitle);
    }
}
