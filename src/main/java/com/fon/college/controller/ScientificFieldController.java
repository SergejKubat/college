package com.fon.college.controller;

import com.fon.college.domain.ScientificField;
import com.fon.college.payload.AcademicTitleDto;
import com.fon.college.payload.ErrorDetailsDto;
import com.fon.college.payload.ScientificFieldDto;
import com.fon.college.service.ScientificFieldService;
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

@Tag(name = "ScientificField Controller")
@RestController
@RequestMapping("/api/scientific-fields")
public class ScientificFieldController {

    private final ScientificFieldService scientificFieldService;

    public ScientificFieldController(ScientificFieldService scientificFieldService) {
        this.scientificFieldService = scientificFieldService;
    }

    @Operation(summary = "Retrieve all ScientificField entities.")
    @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = ScientificFieldDto.class),
            mediaType = "application/json") })
    @GetMapping("/")
    public ResponseEntity<List<ScientificFieldDto>> getAll() {
        return new ResponseEntity<>(scientificFieldService.getAll(), HttpStatus.OK);
    }

    @Operation(summary = "Retrieve ScientificField entity by id.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = ScientificFieldDto.class),
                    mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = ErrorDetailsDto.class),
                    mediaType = "application/json") })
    })
    @GetMapping("/{id}")
    public ResponseEntity<ScientificFieldDto> getById(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(scientificFieldService.getById(id), HttpStatus.OK);
    }

    @Operation(summary = "Create new ScientificField entity.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = ScientificFieldDto.class),
                    mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = ErrorDetailsDto.class),
                    mediaType = "application/json") })
    })
    @PostMapping("/")
    public ResponseEntity<ScientificFieldDto> create(@RequestBody ScientificFieldDto departmentDto) {
        return new ResponseEntity<>(scientificFieldService.create(departmentDto), HttpStatus.CREATED);
    }

    @Operation(summary = "Update ScientificField entity by id.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = ScientificFieldDto.class),
                    mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = ErrorDetailsDto.class),
                    mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = ErrorDetailsDto.class),
                    mediaType = "application/json") })
    })
    @PutMapping("/{id}")
    public ResponseEntity<ScientificFieldDto> update(@PathVariable(value = "id") long id,
                                                   @RequestBody ScientificFieldDto departmentDto) {
        return new ResponseEntity<>(scientificFieldService.update(id, departmentDto), HttpStatus.OK);
    }

    @Operation(summary = "Delete ScientificField entity by id.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(mediaType = "text/plain") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = ErrorDetailsDto.class),
                    mediaType = "application/json") })
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") long id) {
        scientificFieldService.delete(id);

        return new ResponseEntity<>("Scientific field successfully deleted.", HttpStatus.OK);
    }

}
