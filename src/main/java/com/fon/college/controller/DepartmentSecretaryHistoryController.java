package com.fon.college.controller;

import com.fon.college.payload.DepartmentSecretaryHistoryDto;
import com.fon.college.payload.ErrorDetailsDto;
import com.fon.college.service.DepartmentSecretaryHistoryService;
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

@Tag(name = "DepartmentSecretaryHistory")
@RestController
@RequestMapping("/api")
public class DepartmentSecretaryHistoryController {

    private final DepartmentSecretaryHistoryService departmentSecretaryHistoryService;

    public DepartmentSecretaryHistoryController(DepartmentSecretaryHistoryService departmentSecretaryHistoryService) {
        this.departmentSecretaryHistoryService = departmentSecretaryHistoryService;
    }

    @Operation(summary = "Retrieve all DepartmentSecretaryHistory entities.")
    @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = DepartmentSecretaryHistoryDto.class),
            mediaType = "application/json")})
    @GetMapping("/department-secretary-histories")
    public ResponseEntity<List<DepartmentSecretaryHistoryDto>> getAll() {
        return new ResponseEntity<>(departmentSecretaryHistoryService.getAll(), HttpStatus.OK);
    }

    @Operation(summary = "Retrieve all DepartmentSecretaryHistory entities by Department id.")
    @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = DepartmentSecretaryHistoryDto.class),
            mediaType = "application/json")})
    @GetMapping("/departments/{departmentId}/department-secretary-histories")
    public ResponseEntity<List<DepartmentSecretaryHistoryDto>> getAllByDepartmentId(
            @PathVariable(value = "departmentId") long departmentId) {
        return new ResponseEntity<>(departmentSecretaryHistoryService.getAllByDepartmentId(departmentId), HttpStatus.OK);
    }

    @Operation(summary = "Retrieve all DepartmentSecretaryHistory entities by Member id.")
    @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = DepartmentSecretaryHistoryDto.class),
            mediaType = "application/json")})
    @GetMapping("/members/{memberId}/department-secretary-histories")
    public ResponseEntity<List<DepartmentSecretaryHistoryDto>> getAllBySecretayId(
            @PathVariable(value = "memberId") long memberId) {
        return new ResponseEntity<>(departmentSecretaryHistoryService.getAllByMemeberId(memberId), HttpStatus.OK);
    }

    @Operation(summary = "Retrieve DepartmentSecretaryHistory entity by id.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = DepartmentSecretaryHistoryDto.class),
                    mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ErrorDetailsDto.class),
                    mediaType = "application/json")})
    })
    @GetMapping("/department-secretary-histories/{id}")
    public ResponseEntity<DepartmentSecretaryHistoryDto> getById(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(departmentSecretaryHistoryService.getById(id), HttpStatus.OK);
    }

}
