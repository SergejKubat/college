package com.fon.college.service;

import com.fon.college.payload.DepartmentSecretaryHistoryDto;

import java.util.List;

public interface DepartmentSecretaryHistoryService {
    List<DepartmentSecretaryHistoryDto> getAll();

    List<DepartmentSecretaryHistoryDto> getAllByDepartmentId(long departmentId);

    List<DepartmentSecretaryHistoryDto> getAllByMemeberId(long memberId);

    DepartmentSecretaryHistoryDto getById(long id);
}
