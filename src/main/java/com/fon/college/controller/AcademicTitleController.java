package com.fon.college.controller;

import com.fon.college.payload.AcademicTitleDto;
import com.fon.college.payload.ErrorDetailsDto;
import com.fon.college.service.AcademicTitleService;
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

@Tag(name = "AcademicTitle Controller")
@RestController
@RequestMapping("/api/academic-titles")
public class AcademicTitleController {

    private final AcademicTitleService academicTitleService;

    public AcademicTitleController(AcademicTitleService academicTitleService) {
        this.academicTitleService = academicTitleService;
    }

    @Operation(summary = "Retrieve all AcademicTitle entities.")
    @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = AcademicTitleDto.class),
            mediaType = "application/json")})
    @GetMapping("/")
    public ResponseEntity<List<AcademicTitleDto>> getAll() {
        return new ResponseEntity<>(academicTitleService.getAll(), HttpStatus.OK);
    }

    @Operation(summary = "Retrieve AcademicTitle entity by id.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = AcademicTitleDto.class),
                    mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ErrorDetailsDto.class),
                    mediaType = "application/json")})
    })
    @GetMapping("/{id}")
    public ResponseEntity<AcademicTitleDto> getById(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(academicTitleService.getById(id), HttpStatus.OK);
    }

    @Operation(summary = "Create new AcademicTitle entity.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {@Content(schema = @Schema(implementation = AcademicTitleDto.class),
                    mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema(implementation = ErrorDetailsDto.class),
                    mediaType = "application/json")})
    })
    @PostMapping("/")
    public ResponseEntity<AcademicTitleDto> create(@RequestBody AcademicTitleDto departmentDto) {
        return new ResponseEntity<>(academicTitleService.create(departmentDto), HttpStatus.CREATED);
    }

    @Operation(summary = "Update AcademicTitle entity by id.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = AcademicTitleDto.class),
                    mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema(implementation = ErrorDetailsDto.class),
                    mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ErrorDetailsDto.class),
                    mediaType = "application/json")})
    })
    @PutMapping("/{id}")
    public ResponseEntity<AcademicTitleDto> update(@PathVariable(value = "id") long id,
                                                   @RequestBody AcademicTitleDto departmentDto) {
        return new ResponseEntity<>(academicTitleService.update(id, departmentDto), HttpStatus.OK);
    }

    @Operation(summary = "Delete AcademicTitle entity by id.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(mediaType = "text/plain")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ErrorDetailsDto.class),
                    mediaType = "application/json")})
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") long id) {
        academicTitleService.delete(id);

        return new ResponseEntity<>("Academic title successfully deleted.", HttpStatus.OK);
    }

}
