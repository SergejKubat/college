package com.fon.college.service.impl;

import com.fon.college.domain.Department;
import com.fon.college.domain.DepartmentManagerHistory;
import com.fon.college.domain.DepartmentSecretaryHistory;
import com.fon.college.domain.Member;
import com.fon.college.exception.BadRequestException;
import com.fon.college.exception.ResourceNotFoundException;
import com.fon.college.payload.DepartmentDto;
import com.fon.college.repository.DepartmentManagerHistoryRepository;
import com.fon.college.repository.DepartmentRepository;
import com.fon.college.repository.DepartmentSecretaryHistoryRepository;
import com.fon.college.repository.MemberRepository;
import com.fon.college.service.DepartmentService;
import com.fon.college.service.mapper.DtoMapper;
import com.fon.college.service.mapper.EntityMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EntityMapper entityMapper;
    private final DtoMapper dtoMapper;

    private final DepartmentRepository departmentRepository;
    private final MemberRepository memberRepository;
    private final DepartmentManagerHistoryRepository departmentManagerHistoryRepository;
    private final DepartmentSecretaryHistoryRepository departmentSecretaryHistoryRepository;

    public DepartmentServiceImpl(EntityMapper entityMapper,
                                 DtoMapper dtoMapper,
                                 DepartmentRepository departmentRepository,
                                 MemberRepository memberRepository,
                                 DepartmentManagerHistoryRepository departmentManagerHistoryRepository,
                                 DepartmentSecretaryHistoryRepository departmentSecretaryHistoryRepository) {
        this.entityMapper = entityMapper;
        this.dtoMapper = dtoMapper;
        this.departmentRepository = departmentRepository;
        this.memberRepository = memberRepository;
        this.departmentManagerHistoryRepository = departmentManagerHistoryRepository;
        this.departmentSecretaryHistoryRepository = departmentSecretaryHistoryRepository;
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

        // update manager history
        if (departmentDto.getCurrentManagerId() > 0) {

            if (department.getCurrentManager() == null
                    || department.getCurrentManager().getId() != departmentDto.getCurrentManagerId()) {

                Member member = memberRepository.findById(departmentDto.getCurrentManagerId()).orElseThrow(
                        () -> new ResourceNotFoundException("Member", "id", String.valueOf(departmentDto.getCurrentManagerId())));

                // check if member is not in department
                if (!Objects.equals(department.getId(), member.getDepartment().getId())) {
                    throw new BadRequestException("Member with id: "
                            + member.getId() + " is not in department with id: " + department.getId());
                }

                // check if member is already secretary of department
                if (department.getCurrentSecretary() != null) {
                    if (Objects.equals(department.getCurrentSecretary().getId(), member.getId())) {
                        throw new BadRequestException("Member with id: "
                                + member.getId() + " is already a secretary of department with id: " + department.getId());
                    }
                }

                // update previous entry
                if (department.getCurrentManager() != null) {
                    DepartmentManagerHistory oldDepartmentManagerHistory = departmentManagerHistoryRepository.
                            findPreviousEntry(department.getId(), department.getCurrentManager().getId());

                    if (oldDepartmentManagerHistory != null) {
                        oldDepartmentManagerHistory.setEndDate(new Date());

                        departmentManagerHistoryRepository.save(oldDepartmentManagerHistory);
                    }
                }

                // create new entry
                DepartmentManagerHistory newDepartmentManagerHistory = new DepartmentManagerHistory(null, member,
                        department, new Date(), null);

                departmentManagerHistoryRepository.save(newDepartmentManagerHistory);

                department.setCurrentManager(member);
            }
        }

        // update secretary history
        if (departmentDto.getCurrentSecretaryId() > 0) {

            if (department.getCurrentSecretary() == null
                    || department.getCurrentSecretary().getId() != departmentDto.getCurrentSecretaryId()) {

                Member member = memberRepository.findById(departmentDto.getCurrentSecretaryId()).orElseThrow(
                        () -> new ResourceNotFoundException("Member", "id", String.valueOf(departmentDto.getCurrentSecretaryId())));

                // check if member is not in department
                if (!Objects.equals(department.getId(), member.getDepartment().getId())) {
                    throw new BadRequestException("Member with id: "
                            + member.getId() + " is not in department with id: " + department.getId());
                }

                // check if member is already manager of department
                if (department.getCurrentManager() != null) {
                    if (Objects.equals(department.getCurrentManager().getId(), member.getId())) {
                        throw new BadRequestException("Member with id: "
                                + member.getId() + " is already a manager of department with id: " + department.getId());
                    }
                }

                // update previous entry
                if (department.getCurrentSecretary() != null) {
                    DepartmentSecretaryHistory oldDepartmentSecretaryHistory = departmentSecretaryHistoryRepository.
                            findPreviousEntry(department.getId(), department.getCurrentSecretary().getId());

                    if (oldDepartmentSecretaryHistory != null) {
                        oldDepartmentSecretaryHistory.setEndDate(new Date());

                        departmentSecretaryHistoryRepository.save(oldDepartmentSecretaryHistory);
                    }
                }

                // create new entry
                DepartmentSecretaryHistory newDepartmentSecretaryHistory = new DepartmentSecretaryHistory(null, member,
                        department, new Date(), null);

                departmentSecretaryHistoryRepository.save(newDepartmentSecretaryHistory);

                department.setCurrentSecretary(member);
            }
        }

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
