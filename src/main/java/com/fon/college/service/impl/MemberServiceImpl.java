package com.fon.college.service.impl;

import com.fon.college.domain.Member;
import com.fon.college.exception.ResourceNotFoundException;
import com.fon.college.payload.MemberDto;
import com.fon.college.repository.MemberRepository;
import com.fon.college.service.MemberService;
import com.fon.college.service.mapper.DtoMapper;
import com.fon.college.service.mapper.EntityMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final EntityMapper entityMapper;
    private final DtoMapper dtoMapper;

    private final MemberRepository memberRepository;

    public MemberServiceImpl(EntityMapper entityMapper,
                             DtoMapper dtoMapper,
                             MemberRepository memberRepository) {
        this.entityMapper = entityMapper;
        this.dtoMapper = dtoMapper;
        this.memberRepository = memberRepository;
    }

    @Override
    public List<MemberDto> getAll() {
        List<Member> members = memberRepository.findAll();

        return members.stream().map(dtoMapper::mapToMemberDto).toList();
    }

    @Override
    public List<MemberDto> getAllByDepartmentId(long departmentId) {
        List<Member> members = memberRepository.findAllByDepartmentId(departmentId);

        return members.stream().map(dtoMapper::mapToMemberDto).toList();
    }

    @Override
    public MemberDto getById(long id) {
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Member", "id", String.valueOf(id)));

        return dtoMapper.mapToMemberDto(member);
    }

    @Override
    public MemberDto create(MemberDto memberDto) {
        Member member = entityMapper.mapToMemberEntity(memberDto);

        Member createdMember = memberRepository.save(member);

        return dtoMapper.mapToMemberDto(createdMember);
    }

    @Override
    public MemberDto update(long id, MemberDto memberDto) {
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Member", "id", String.valueOf(id)));

        member.setFirstName(memberDto.getFirstName());
        member.setLastName(memberDto.getLastName());

        Member updatedMember = memberRepository.save(member);

        return dtoMapper.mapToMemberDto(updatedMember);
    }

    @Override
    public void delete(long id) {
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Member", "id", String.valueOf(id)));

        memberRepository.delete(member);
    }
}
