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
@RequestMapping("/api/department-manager-histories")
public class DepartmentManagerHistoryController {

    private final DepartmentManagerHistoryService departmentManagerHistoryService;

    public DepartmentManagerHistoryController(DepartmentManagerHistoryService departmentManagerHistoryService) {
        this.departmentManagerHistoryService = departmentManagerHistoryService;
    }

    @GetMapping("/")
    public ResponseEntity<List<DepartmentManagerHistoryDto>> getAll() {
        return new ResponseEntity<>(departmentManagerHistoryService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentManagerHistoryDto> getById(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(departmentManagerHistoryService.getById(id), HttpStatus.OK);
    }

}
