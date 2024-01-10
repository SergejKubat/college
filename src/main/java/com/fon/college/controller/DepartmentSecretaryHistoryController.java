package com.fon.college.controller;

import com.fon.college.payload.DepartmentSecretaryHistoryDto;
import com.fon.college.service.DepartmentSecretaryHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentSecretaryHistoryController {

    private final DepartmentSecretaryHistoryService departmentSecretaryHistoryService;

    public DepartmentSecretaryHistoryController(DepartmentSecretaryHistoryService departmentSecretaryHistoryService) {
        this.departmentSecretaryHistoryService = departmentSecretaryHistoryService;
    }

    @GetMapping("/department-secretary-histories")
    public ResponseEntity<List<DepartmentSecretaryHistoryDto>> getAll() {
        return new ResponseEntity<>(departmentSecretaryHistoryService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/departments/{departmentId}/department-secretary-histories")
    public ResponseEntity<List<DepartmentSecretaryHistoryDto>> getAllByDepartmentId(
            @PathVariable(value = "departmentId") long departmentId) {
        return new ResponseEntity<>(departmentSecretaryHistoryService.getAllByDepartmentId(departmentId), HttpStatus.OK);
    }

    @GetMapping("/members/{memberId}/department-secretary-histories")
    public ResponseEntity<List<DepartmentSecretaryHistoryDto>> getAllBySecretayId(
            @PathVariable(value = "memberId") long memberId) {
        return new ResponseEntity<>(departmentSecretaryHistoryService.getAllByMemeberId(memberId), HttpStatus.OK);
    }

    @GetMapping("/department-secretary-histories/{id}")
    public ResponseEntity<DepartmentSecretaryHistoryDto> getById(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(departmentSecretaryHistoryService.getById(id), HttpStatus.OK);
    }

}
