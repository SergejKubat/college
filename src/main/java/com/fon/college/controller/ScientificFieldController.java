package com.fon.college.controller;

import com.fon.college.payload.ScientificFieldDto;
import com.fon.college.service.ScientificFieldService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scientific-fields")
public class ScientificFieldController {

    private final ScientificFieldService scientificFieldService;

    public ScientificFieldController(ScientificFieldService scientificFieldService) {
        this.scientificFieldService = scientificFieldService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ScientificFieldDto>> getAll() {
        return new ResponseEntity<>(scientificFieldService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScientificFieldDto> getById(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(scientificFieldService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<ScientificFieldDto> create(@RequestBody ScientificFieldDto departmentDto) {
        return new ResponseEntity<>(scientificFieldService.create(departmentDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScientificFieldDto> update(@PathVariable(value = "id") long id,
                                                   @RequestBody ScientificFieldDto departmentDto) {
        return new ResponseEntity<>(scientificFieldService.update(id, departmentDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") long id) {
        scientificFieldService.delete(id);

        return new ResponseEntity<>("Scientific field successfully deleted.", HttpStatus.OK);
    }

}
