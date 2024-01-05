package com.fon.college.service.impl;

import com.fon.college.domain.Department;
import com.fon.college.exception.ResourceNotFoundException;
import com.fon.college.payload.DepartmentDto;
import com.fon.college.repository.DepartmentRepository;
import com.fon.college.service.DepartmentService;
import com.fon.college.service.mapper.DtoMapper;
import com.fon.college.service.mapper.EntityMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EntityMapper entityMapper;
    private final DtoMapper dtoMapper;

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(EntityMapper entityMapper,
                                 DtoMapper dtoMapper,
                                 DepartmentRepository departmentRepository) {
        this.entityMapper = entityMapper;
        this.dtoMapper = dtoMapper;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<DepartmentDto> getAll() {
        List<Department> departments = departmentRepository.findAll();

        return departments.stream().map(dtoMapper::mapToDepartmentDto).toList();
    }

    @Override
    public DepartmentDto getById(long id) {
        Department department = departmentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Department", "id", String.valueOf(id)));

        return dtoMapper.mapToDepartmentDto(department);
    }

    @Override
    public DepartmentDto create(DepartmentDto departmentDto) {
        Department department = entityMapper.mapToDepartmentEntity(departmentDto);

        Department createdDepartment = departmentRepository.save(department);

        return dtoMapper.mapToDepartmentDto(createdDepartment);
    }

    @Override
    public DepartmentDto update(long id, DepartmentDto departmentDto) {
        Department department = departmentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Department", "id", String.valueOf(id)));

        department.setName(departmentDto.getName());
        department.setShortName(departmentDto.getShortName());

        Department updatedDepartment = departmentRepository.save(department);

        return dtoMapper.mapToDepartmentDto(updatedDepartment);
    }

    @Override
    public void delete(long id) {
        Department department = departmentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Department", "id", String.valueOf(id)));

        departmentRepository.delete(department);
    }
}
