package com.fon.college.service;

import com.fon.college.payload.DepartmentManagerHistoryDto;

import java.util.List;

public interface DepartmentManagerHistoryService {
    List<DepartmentManagerHistoryDto> getAll();

    List<DepartmentManagerHistoryDto> getAllByDepartmentId(long departmentId);

    List<DepartmentManagerHistoryDto> getAllByMemeberId(long memberId);

    DepartmentManagerHistoryDto getById(long id);
}
