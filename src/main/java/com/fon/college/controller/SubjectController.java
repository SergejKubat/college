package com.fon.college.controller;

import com.fon.college.payload.DepartmentDto;
import com.fon.college.payload.SubjectDto;
import com.fon.college.service.SubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/")
    public ResponseEntity<List<SubjectDto>> getAll() {
        return new ResponseEntity<>(subjectService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectDto> getById(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(subjectService.getById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<SubjectDto> create(@RequestBody SubjectDto departmentDto) {
        return new ResponseEntity<>(subjectService.create(departmentDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubjectDto> update(@PathVariable(value = "id") long id,
                                                @RequestBody SubjectDto departmentDto) {
        return new ResponseEntity<>(subjectService.update(id, departmentDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") long id) {
        subjectService.delete(id);

        return new ResponseEntity<>("Subject successfully deleted.", HttpStatus.OK);
    }
}
