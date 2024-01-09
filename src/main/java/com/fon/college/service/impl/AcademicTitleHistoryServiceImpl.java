package com.fon.college.service.impl;

import com.fon.college.domain.AcademicTitleHistory;
import com.fon.college.exception.ResourceNotFoundException;
import com.fon.college.payload.AcademicTitleHistoryDto;
import com.fon.college.repository.AcademicTitleHistoryRepository;
import com.fon.college.service.AcademicTitleHistoryService;
import com.fon.college.service.mapper.DtoMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicTitleHistoryServiceImpl implements AcademicTitleHistoryService {

    private final DtoMapper dtoMapper;

    private final AcademicTitleHistoryRepository academicTitleHistoryRepository;

    public AcademicTitleHistoryServiceImpl(DtoMapper dtoMapper,
                                           AcademicTitleHistoryRepository academicTitleHistoryRepository) {
        this.dtoMapper = dtoMapper;
        this.academicTitleHistoryRepository = academicTitleHistoryRepository;
    }

    @Override
    public List<AcademicTitleHistoryDto> getAll() {
        List<AcademicTitleHistory> academicTitleHistories = academicTitleHistoryRepository.findAll();

        return academicTitleHistories.stream().map(dtoMapper::mapToAcademicTitleHistoryDto).toList();
    }

    @Override
    public List<AcademicTitleHistoryDto> getAllByMemberId(long memberId) {
        List<AcademicTitleHistory> academicTitleHistories = academicTitleHistoryRepository.findAllByMemberId(memberId);

        return academicTitleHistories.stream().map(dtoMapper::mapToAcademicTitleHistoryDto).toList();
    }

    @Override
    public AcademicTitleHistoryDto getById(long id) {
        AcademicTitleHistory academicTitleHistory = academicTitleHistoryRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("AcademicTitleHistory", "id", String.valueOf(id)));

        return dtoMapper.mapToAcademicTitleHistoryDto(academicTitleHistory);
    }
}
