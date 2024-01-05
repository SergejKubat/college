package com.fon.college.service.impl;

import com.fon.college.payload.MemberDto;
import com.fon.college.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Override
    public List<MemberDto> getAll() {
        return null;
    }

    @Override
    public List<MemberDto> getAllByDepartmentId(long departmentId) {
        return null;
    }

    @Override
    public MemberDto getById(long id) {
        return null;
    }

    @Override
    public MemberDto create(MemberDto memberDto) {
        return null;
    }

    @Override
    public MemberDto update(long id, MemberDto memberDto) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
