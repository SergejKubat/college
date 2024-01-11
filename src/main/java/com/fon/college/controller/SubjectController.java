package com.fon.college.controller;

import com.fon.college.payload.AcademicTitleDto;
import com.fon.college.payload.ErrorDetailsDto;
import com.fon.college.payload.SubjectDto;
import com.fon.college.service.SubjectService;
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

@Tag(name = "Subject Controller")
@RestController
@RequestMapping("/api")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Operation(summary = "Retrieve all Subject entities.")
    @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = SubjectDto.class),
            mediaType = "application/json") })
    @GetMapping("/subjects")
    public ResponseEntity<List<SubjectDto>> getAll() {
        return new ResponseEntity<>(subjectService.getAll(), HttpStatus.OK);
    }

    @Operation(summary = "Retrieve all Subject entities by Department id.")
    @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = SubjectDto.class),
            mediaType = "application/json") })
    @GetMapping("/departments/{departmentId}/subjects")
    public ResponseEntity<List<SubjectDto>> getAllByDepartmentId(
            @PathVariable(value = "departmentId") long departmentId) {
        return new ResponseEntity<>(subjectService.getAllByDepartmentId(departmentId), HttpStatus.OK);
    }

    @Operation(summary = "Retrieve Subject entity by id.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = SubjectDto.class),
                    mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = ErrorDetailsDto.class),
                    mediaType = "application/json") })
    })
    @GetMapping("/subjects/{id}")
    public ResponseEntity<SubjectDto> getById(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(subjectService.getById(id), HttpStatus.OK);
    }

    @Operation(summary = "Create new Subject entity.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = SubjectDto.class),
                    mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = ErrorDetailsDto.class),
                    mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = ErrorDetailsDto.class),
                    mediaType = "application/json") })
    })
    @PostMapping("/subjects")
    public ResponseEntity<SubjectDto> create(@RequestBody SubjectDto departmentDto) {
        return new ResponseEntity<>(subjectService.create(departmentDto), HttpStatus.CREATED);
    }

    @Operation(summary = "Update Subject entity by id.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = SubjectDto.class),
                    mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = ErrorDetailsDto.class),
                    mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = ErrorDetailsDto.class),
                    mediaType = "application/json") })
    })
    @PutMapping("/subjects/{id}")
    public ResponseEntity<SubjectDto> update(@PathVariable(value = "id") long id,
                                                @RequestBody SubjectDto departmentDto) {
        return new ResponseEntity<>(subjectService.update(id, departmentDto), HttpStatus.OK);
    }

    @Operation(summary = "Delete Subject entity by id.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(mediaType = "text/plain") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = ErrorDetailsDto.class),
                    mediaType = "application/json") })
    })
    @DeleteMapping("/subjects/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") long id) {
        subjectService.delete(id);

        return new ResponseEntity<>("Subject successfully deleted.", HttpStatus.OK);
    }

}
