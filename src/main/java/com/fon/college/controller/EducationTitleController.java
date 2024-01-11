package com.fon.college.controller;

import com.fon.college.payload.EducationTitleDto;
import com.fon.college.payload.ErrorDetailsDto;
import com.fon.college.service.EducationTitleService;
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

@Tag(name = "EducationTitle Controller")
@RestController
@RequestMapping("/api/education-titles")
public class EducationTitleController {

    private final EducationTitleService educationTitleService;

    public EducationTitleController(EducationTitleService educationTitleService) {
        this.educationTitleService = educationTitleService;
    }

    @Operation(summary = "Retrieve all EducationTitle entities.")
    @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = EducationTitleDto.class),
            mediaType = "application/json")})
    @GetMapping("/")
    public ResponseEntity<List<EducationTitleDto>> getAll() {
        return new ResponseEntity<>(educationTitleService.getAll(), HttpStatus.OK);
    }

    @Operation(summary = "Retrieve EducationTitle entity by id.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = EducationTitleDto.class),
                    mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ErrorDetailsDto.class),
                    mediaType = "application/json")})
    })
    @GetMapping("/{id}")
    public ResponseEntity<EducationTitleDto> getById(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(educationTitleService.getById(id), HttpStatus.OK);
    }

    @Operation(summary = "Create new EducationTitle entity.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {@Content(schema = @Schema(implementation = EducationTitleDto.class),
                    mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema(implementation = ErrorDetailsDto.class),
                    mediaType = "application/json")})
    })
    @PostMapping("/")
    public ResponseEntity<EducationTitleDto> create(@RequestBody EducationTitleDto departmentDto) {
        return new ResponseEntity<>(educationTitleService.create(departmentDto), HttpStatus.CREATED);
    }

    @Operation(summary = "Update EducationTitle entity by id.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = EducationTitleDto.class),
                    mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema(implementation = ErrorDetailsDto.class),
                    mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ErrorDetailsDto.class),
                    mediaType = "application/json")})
    })
    @PutMapping("/{id}")
    public ResponseEntity<EducationTitleDto> update(@PathVariable(value = "id") long id,
                                                    @RequestBody EducationTitleDto departmentDto) {
        return new ResponseEntity<>(educationTitleService.update(id, departmentDto), HttpStatus.OK);
    }

    @Operation(summary = "Delete EducationTitle entity by id.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(mediaType = "text/plain")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ErrorDetailsDto.class),
                    mediaType = "application/json")})
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") long id) {
        educationTitleService.delete(id);

        return new ResponseEntity<>("Education title successfully deleted.", HttpStatus.OK);
    }

}
