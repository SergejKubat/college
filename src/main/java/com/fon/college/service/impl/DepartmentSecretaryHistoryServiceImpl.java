package com.fon.college.service.impl;

import com.fon.college.domain.DepartmentSecretaryHistory;
import com.fon.college.exception.ResourceNotFoundException;
import com.fon.college.payload.DepartmentSecretaryHistoryDto;
import com.fon.college.repository.DepartmentSecretaryHistoryRepository;
import com.fon.college.service.DepartmentSecretaryHistoryService;
import com.fon.college.service.mapper.DtoMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentSecretaryHistoryServiceImpl implements DepartmentSecretaryHistoryService {

    private final DtoMapper dtoMapper;

    private final DepartmentSecretaryHistoryRepository departmentSecretaryHistoryRepository;

    public DepartmentSecretaryHistoryServiceImpl(DtoMapper dtoMapper,
                                                 DepartmentSecretaryHistoryRepository departmentSecretaryHistoryRepository) {
        this.dtoMapper = dtoMapper;
        this.departmentSecretaryHistoryRepository = departmentSecretaryHistoryRepository;
    }

    @Override
    public List<DepartmentSecretaryHistoryDto> getAll() {
        List<DepartmentSecretaryHistory> departmentSecretaryHistories = departmentSecretaryHistoryRepository.findAll();

        return departmentSecretaryHistories.stream().map(dtoMapper::mapToDepartmentSecretaryHistoryDto).toList();
    }

    @Override
    public List<DepartmentSecretaryHistoryDto> getAllByDepartmentId(long departmentId) {
        List<DepartmentSecretaryHistory> departmentSecretaryHistories =
                departmentSecretaryHistoryRepository.findAllByDepartmentId(departmentId);

        return departmentSecretaryHistories.stream().map(dtoMapper::mapToDepartmentSecretaryHistoryDto).toList();
    }

    @Override
    public List<DepartmentSecretaryHistoryDto> getAllByMemeberId(long memberId) {
        List<DepartmentSecretaryHistory> departmentSecretaryHistories =
                departmentSecretaryHistoryRepository.findAllBySecretaryId(memberId);

        return departmentSecretaryHistories.stream().map(dtoMapper::mapToDepartmentSecretaryHistoryDto).toList();
    }

    @Override
    public DepartmentSecretaryHistoryDto getById(long id) {
        DepartmentSecretaryHistory departmentSecretaryHistory = departmentSecretaryHistoryRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("DepartmentSecretaryHistory", "id", String.valueOf(id)));

        return dtoMapper.mapToDepartmentSecretaryHistoryDto(departmentSecretaryHistory);
    }

}
