package com.fon.college.service;

import com.fon.college.domain.Department;
import com.fon.college.exception.ResourceNotFoundException;
import com.fon.college.payload.DepartmentDto;
import com.fon.college.repository.DepartmentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @Test
    @DisplayName("Get all departments")
    void getAllDepartmentsTest() {
        List<Department> departments = Arrays.asList(
                new Department(1L, "Department 1", "Dept 1"),
                new Department(1L, "Department 2", "Dept 2")
        );

        when(departmentRepository.findAll()).thenReturn(departments);

        List<DepartmentDto> departmentDtoList = departmentService.getAll();

        assertEquals(departments.size(), departmentDtoList.size());
    }

    @Test
    @DisplayName("Get department by id")
    void getDepartmentByIdTest() {
        long departmentId = 1L;

        Department department = new Department(departmentId, "Department 1", "Dept 1");

        when(departmentRepository.findById(departmentId)).thenReturn(Optional.of(department));

        DepartmentDto departmentDto = departmentService.getById(departmentId);

        assertNotNull(departmentDto);
    }

    @Test
    @DisplayName("Get department by id - failure")
    void getDepartmentByIdFailureTest() {
        long departmentId = 1L;

        assertThrows(ResourceNotFoundException.class, () -> {
            departmentService.getById(departmentId);
        });
    }

    @Test
    @DisplayName("Create department")
    void createDepartmentTest() {
        DepartmentDto departmentDto = new DepartmentDto();

        Department department = new Department(1L, "Department 1", "Dept 1");

        when(departmentRepository.save(any(Department.class))).thenReturn(department);

        DepartmentDto createdDepartmentDto = departmentService.create(departmentDto);

        assertNotNull(createdDepartmentDto);
    }

    @Test
    @DisplayName("Update department")
    void updateDepartmentTest() {
        long departmentId = 1L;

        DepartmentDto departmentDto = new DepartmentDto();

        Department department = new Department(departmentId, "Department 1", "Dept 1");

        when(departmentRepository.findById(departmentId)).thenReturn(Optional.of(department));

        when(departmentRepository.save(any(Department.class))).thenReturn(department);

        DepartmentDto updatedDepartmentDto = departmentService.update(departmentId, departmentDto);

        assertNotNull(updatedDepartmentDto);
    }

    @Test
    @DisplayName("Update department - failure")
    void updateDepartmentFailureTest() {
        long departmentId = 1L;

        DepartmentDto departmentDto = new DepartmentDto();

        departmentDto.setName("Updated name");
        departmentDto.setShortName("Updated short name");

        assertThrows(ResourceNotFoundException.class, () -> {
            departmentService.update(departmentId, departmentDto);
        });
    }

    @Test
    @DisplayName("Delete department")
    void deleteDepartmentTest() {
        long departmentId = 1L;

        Department department = new Department(departmentId, "Department 1", "Dept 1");

        when(departmentRepository.findById(departmentId)).thenReturn(Optional.of(department));

        departmentService.delete(departmentId);

        verify(departmentRepository, times(1)).delete(department);
    }

    @Test
    @DisplayName("Delete department - failure")
    void deleteDepartmentFailureTest() {
        long departmentId = 1L;

        assertThrows(ResourceNotFoundException.class, () -> {
            departmentService.delete(departmentId);
        });
    }
}
