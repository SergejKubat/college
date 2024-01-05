package com.fon.college.service;

import com.fon.college.payload.MemberDto;

import java.util.List;

public interface MemberService {
    List<MemberDto> getAll();

    List<MemberDto> getAllByDepartmentId(long departmentId);

    MemberDto getById(long id);

    MemberDto create(MemberDto memberDto);

    MemberDto update(long id, MemberDto memberDto);

    void delete(long id);
}
