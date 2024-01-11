package com.fon.college.controller;

import com.fon.college.payload.AcademicTitleDto;
import com.fon.college.payload.DepartmentDto;
import com.fon.college.payload.ErrorDetailsDto;
import com.fon.college.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Department Controller")
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Operation(summary = "Retrieve all Department entities.")
    @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = DepartmentDto.class),
            mediaType = "application/json") })
    @GetMapping("/")
    public ResponseEntity<List<DepartmentDto>> getAll() {
        return new ResponseEntity<>(departmentService.getAll(), HttpStatus.OK);
    }

    @Operation(summary = "Retrieve Department entity by id.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = DepartmentDto.class),
                    mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = ErrorDetailsDto.class),
                    mediaType = "application/json") })
    })
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getById(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(departmentService.getById(id), HttpStatus.OK);
    }

    @Operation(summary = "Create new Department entity.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = DepartmentDto.class),
                    mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = ErrorDetailsDto.class),
                    mediaType = "application/json") })
    })
    @PostMapping("/")
    public ResponseEntity<DepartmentDto> create(@RequestBody DepartmentDto departmentDto) {
        return new ResponseEntity<>(departmentService.create(departmentDto), HttpStatus.CREATED);
    }

    @Operation(summary = "Update Department entity by id.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = DepartmentDto.class),
                    mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = ErrorDetailsDto.class),
                    mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = ErrorDetailsDto.class),
                    mediaType = "application/json") })
    })
    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDto> update(@PathVariable(value = "id") long id,
                                                @RequestBody DepartmentDto departmentDto) {
        return new ResponseEntity<>(departmentService.update(id, departmentDto), HttpStatus.OK);
    }

    @Operation(summary = "Delete Department entity by id.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(mediaType = "text/plain") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = ErrorDetailsDto.class),
                    mediaType = "application/json") })
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") long id) {
        departmentService.delete(id);

        return new ResponseEntity<>("Department successfully deleted.", HttpStatus.OK);
    }

}
