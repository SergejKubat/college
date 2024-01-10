package com.fon.college.controller;

import com.fon.college.payload.DepartmentDto;
import com.fon.college.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/")
    public ResponseEntity<List<DepartmentDto>> getAll() {
        return new ResponseEntity<>(departmentService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getById(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(departmentService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<DepartmentDto> create(@RequestBody DepartmentDto departmentDto) {
        return new ResponseEntity<>(departmentService.create(departmentDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDto> update(@PathVariable(value = "id") long id,
                                                @RequestBody DepartmentDto departmentDto) {
        return new ResponseEntity<>(departmentService.update(id, departmentDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") long id) {
        departmentService.delete(id);

        return new ResponseEntity<>("Department successfully deleted.", HttpStatus.OK);
    }

}
