package com.fon.college.controller;

import com.fon.college.payload.AcademicTitleDto;
import com.fon.college.service.AcademicTitleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/academic-titles")
public class AcademicTitleController {

    private final AcademicTitleService academicTitleService;

    public AcademicTitleController(AcademicTitleService academicTitleService) {
        this.academicTitleService = academicTitleService;
    }

    @GetMapping("/")
    public ResponseEntity<List<AcademicTitleDto>> getAll() {
        return new ResponseEntity<>(academicTitleService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcademicTitleDto> getById(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(academicTitleService.getById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<AcademicTitleDto> create(@RequestBody AcademicTitleDto departmentDto) {
        return new ResponseEntity<>(academicTitleService.create(departmentDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AcademicTitleDto> update(@PathVariable(value = "id") long id,
                                                @RequestBody AcademicTitleDto departmentDto) {
        return new ResponseEntity<>(academicTitleService.update(id, departmentDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") long id) {
        academicTitleService.delete(id);

        return new ResponseEntity<>("Academic title successfully deleted.", HttpStatus.OK);
    }
}
