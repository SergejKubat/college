package com.fon.college.controller;

import com.fon.college.payload.EducationTitleDto;
import com.fon.college.service.EducationTitleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/education-titles")
public class EducationTitleController {

    private final EducationTitleService educationTitleService;

    public EducationTitleController(EducationTitleService educationTitleService) {
        this.educationTitleService = educationTitleService;
    }

    @GetMapping("/")
    public ResponseEntity<List<EducationTitleDto>> getAll() {
        return new ResponseEntity<>(educationTitleService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EducationTitleDto> getById(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(educationTitleService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<EducationTitleDto> create(@RequestBody EducationTitleDto departmentDto) {
        return new ResponseEntity<>(educationTitleService.create(departmentDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EducationTitleDto> update(@PathVariable(value = "id") long id,
                                                   @RequestBody EducationTitleDto departmentDto) {
        return new ResponseEntity<>(educationTitleService.update(id, departmentDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") long id) {
        educationTitleService.delete(id);

        return new ResponseEntity<>("Education title successfully deleted.", HttpStatus.OK);
    }

}
