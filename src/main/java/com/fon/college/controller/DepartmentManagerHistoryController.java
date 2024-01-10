package com.fon.college.controller;

import com.fon.college.payload.DepartmentManagerHistoryDto;
import com.fon.college.service.DepartmentManagerHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentManagerHistoryController {

    private final DepartmentManagerHistoryService departmentManagerHistoryService;

    public DepartmentManagerHistoryController(DepartmentManagerHistoryService departmentManagerHistoryService) {
        this.departmentManagerHistoryService = departmentManagerHistoryService;
    }

    @GetMapping("/department-manager-histories")
    public ResponseEntity<List<DepartmentManagerHistoryDto>> getAll() {
        return new ResponseEntity<>(departmentManagerHistoryService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/departments/{departmentId}/department-manager-histories")
    public ResponseEntity<List<DepartmentManagerHistoryDto>> getAllByDepartmentId(
            @PathVariable(value = "departmentId") long departmentId) {
        return new ResponseEntity<>(departmentManagerHistoryService.getAllByDepartmentId(departmentId), HttpStatus.OK);
    }

    @GetMapping("/members/{memberId}/department-manager-histories")
    public ResponseEntity<List<DepartmentManagerHistoryDto>> getAllByManagerId(
            @PathVariable(value = "memberId") long memberId) {
        return new ResponseEntity<>(departmentManagerHistoryService.getAllByMemeberId(memberId), HttpStatus.OK);
    }

    @GetMapping("/department-manager-histories/{id}")
    public ResponseEntity<DepartmentManagerHistoryDto> getById(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(departmentManagerHistoryService.getById(id), HttpStatus.OK);
    }

}
