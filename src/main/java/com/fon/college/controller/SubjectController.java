package com.fon.college.controller;

import com.fon.college.payload.SubjectDto;
import com.fon.college.service.SubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/subjects")
    public ResponseEntity<List<SubjectDto>> getAll() {
        return new ResponseEntity<>(subjectService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/departments/{departmentId}/subjects")
    public ResponseEntity<List<SubjectDto>> getAllByDepartmentId(
            @PathVariable(value = "departmentId") long departmentId) {
        return new ResponseEntity<>(subjectService.getAllByDepartmentId(departmentId), HttpStatus.OK);
    }

    @GetMapping("/subjects/{id}")
    public ResponseEntity<SubjectDto> getById(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(subjectService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/subjects")
    public ResponseEntity<SubjectDto> create(@RequestBody SubjectDto departmentDto) {
        return new ResponseEntity<>(subjectService.create(departmentDto), HttpStatus.CREATED);
    }

    @PutMapping("/subjects/{id}")
    public ResponseEntity<SubjectDto> update(@PathVariable(value = "id") long id,
                                                @RequestBody SubjectDto departmentDto) {
        return new ResponseEntity<>(subjectService.update(id, departmentDto), HttpStatus.OK);
    }

    @DeleteMapping("/subjects/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") long id) {
        subjectService.delete(id);

        return new ResponseEntity<>("Subject successfully deleted.", HttpStatus.OK);
    }

}
