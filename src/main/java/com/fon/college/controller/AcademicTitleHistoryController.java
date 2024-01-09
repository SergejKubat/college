package com.fon.college.controller;

import com.fon.college.payload.AcademicTitleHistoryDto;
import com.fon.college.service.AcademicTitleHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/academic-title-histories")
public class AcademicTitleHistoryController {

    private final AcademicTitleHistoryService academicTitleHistoryService;

    public AcademicTitleHistoryController(AcademicTitleHistoryService academicTitleHistoryService) {
        this.academicTitleHistoryService = academicTitleHistoryService;
    }

    @GetMapping("/")
    public ResponseEntity<List<AcademicTitleHistoryDto>> getAll() {
        return new ResponseEntity<>(academicTitleHistoryService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcademicTitleHistoryDto> getById(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(academicTitleHistoryService.getById(id), HttpStatus.OK);
    }
}
