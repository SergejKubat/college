package com.fon.college.service;

import com.fon.college.payload.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    List<DepartmentDto> getAll();

    DepartmentDto getById(long id);

    DepartmentDto create(DepartmentDto departmentDto);

    DepartmentDto update(long id, DepartmentDto departmentDto);

    void delete(long id);
}
