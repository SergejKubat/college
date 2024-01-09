package com.fon.college.service;

import com.fon.college.payload.AcademicTitleHistoryDto;

import java.util.List;

public interface AcademicTitleHistoryService {
    List<AcademicTitleHistoryDto> getAll();

    List<AcademicTitleHistoryDto> getAllByMemberId(long memberId);

    AcademicTitleHistoryDto getById(long id);
}
