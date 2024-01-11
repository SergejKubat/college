package com.fon.college.controller;

import com.fon.college.payload.AcademicTitleHistoryDto;
import com.fon.college.payload.ErrorDetailsDto;
import com.fon.college.service.AcademicTitleHistoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "AcademicTitleHistory Controller")
@RestController
@RequestMapping("/api")
public class AcademicTitleHistoryController {

    private final AcademicTitleHistoryService academicTitleHistoryService;

    public AcademicTitleHistoryController(AcademicTitleHistoryService academicTitleHistoryService) {
        this.academicTitleHistoryService = academicTitleHistoryService;
    }

    @Operation(summary = "Retrieve all AcademicTitleHistory entities.")
    @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = AcademicTitleHistoryDto.class),
            mediaType = "application/json")})
    @GetMapping("/academic-title-histories")
    public ResponseEntity<List<AcademicTitleHistoryDto>> getAll() {
        return new ResponseEntity<>(academicTitleHistoryService.getAll(), HttpStatus.OK);
    }

    @Operation(summary = "Retrieve all AcademicTitleHistory entities by Member id.")
    @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = AcademicTitleHistoryDto.class),
            mediaType = "application/json")})
    @GetMapping("/members/{memberId}/academic-title-histories")
    public ResponseEntity<List<AcademicTitleHistoryDto>> getAllByMemberId(@PathVariable(value = "memberId") long memberId) {
        return new ResponseEntity<>(academicTitleHistoryService.getAllByMemberId(memberId), HttpStatus.OK);
    }

    @Operation(summary = "Retrieve AcademicTitleHistory entity by id.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = AcademicTitleHistoryDto.class),
                    mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ErrorDetailsDto.class),
                    mediaType = "application/json")})
    })
    @GetMapping("/academic-title-histories/{id}")
    public ResponseEntity<AcademicTitleHistoryDto> getById(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(academicTitleHistoryService.getById(id), HttpStatus.OK);
    }

}
