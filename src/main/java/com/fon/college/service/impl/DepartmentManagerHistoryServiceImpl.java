package com.fon.college.service.impl;

import com.fon.college.domain.DepartmentManagerHistory;
import com.fon.college.exception.ResourceNotFoundException;
import com.fon.college.payload.DepartmentManagerHistoryDto;
import com.fon.college.repository.DepartmentManagerHistoryRepository;
import com.fon.college.service.DepartmentManagerHistoryService;
import com.fon.college.service.mapper.DtoMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentManagerHistoryServiceImpl implements DepartmentManagerHistoryService {

    private final DtoMapper dtoMapper;

    private final DepartmentManagerHistoryRepository departmentManagerHistoryRepository;

    public DepartmentManagerHistoryServiceImpl(DtoMapper dtoMapper,
                                               DepartmentManagerHistoryRepository departmentManagerHistoryRepository) {
        this.dtoMapper = dtoMapper;
        this.departmentManagerHistoryRepository = departmentManagerHistoryRepository;
    }

    @Override
    public List<DepartmentManagerHistoryDto> getAll() {
        List<DepartmentManagerHistory> departmentManagerHistories = departmentManagerHistoryRepository.findAll();

        return departmentManagerHistories.stream().map(dtoMapper::mapToDepartmentManagerHistoryDto).toList();
    }

    @Override
    public List<DepartmentManagerHistoryDto> getAllByDepartmentId(long departmentId) {
        List<DepartmentManagerHistory> departmentManagerHistories =
                departmentManagerHistoryRepository.findAllByDepartmentId(departmentId);

        return departmentManagerHistories.stream().map(dtoMapper::mapToDepartmentManagerHistoryDto).toList();
    }

    @Override
    public List<DepartmentManagerHistoryDto> getAllByMemeberId(long memberId) {
        List<DepartmentManagerHistory> departmentManagerHistories =
                departmentManagerHistoryRepository.findAllByManagerId(memberId);

        return departmentManagerHistories.stream().map(dtoMapper::mapToDepartmentManagerHistoryDto).toList();
    }

    @Override
    public DepartmentManagerHistoryDto getById(long id) {
        DepartmentManagerHistory departmentManagerHistory = departmentManagerHistoryRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("DepartmentManagerHistory", "id", String.valueOf(id)));

        return dtoMapper.mapToDepartmentManagerHistoryDto(departmentManagerHistory);
    }
}
