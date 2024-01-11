package com.fon.college.controller;

import com.fon.college.payload.DepartmentManagerHistoryDto;
import com.fon.college.payload.ErrorDetailsDto;
import com.fon.college.service.DepartmentManagerHistoryService;
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

@Tag(name = "DepartmentManagerHistory Controller")
@RestController
@RequestMapping("/api")
public class DepartmentManagerHistoryController {

    private final DepartmentManagerHistoryService departmentManagerHistoryService;

    public DepartmentManagerHistoryController(DepartmentManagerHistoryService departmentManagerHistoryService) {
        this.departmentManagerHistoryService = departmentManagerHistoryService;
    }

    @Operation(summary = "Retrieve all DepartmentManagerHistory entities.")
    @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = DepartmentManagerHistoryDto.class),
            mediaType = "application/json")})
    @GetMapping("/department-manager-histories")
    public ResponseEntity<List<DepartmentManagerHistoryDto>> getAll() {
        return new ResponseEntity<>(departmentManagerHistoryService.getAll(), HttpStatus.OK);
    }

    @Operation(summary = "Retrieve all DepartmentManagerHistory entities by Department id.")
    @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = DepartmentManagerHistoryDto.class),
            mediaType = "application/json")})
    @GetMapping("/departments/{departmentId}/department-manager-histories")
    public ResponseEntity<List<DepartmentManagerHistoryDto>> getAllByDepartmentId(
            @PathVariable(value = "departmentId") long departmentId) {
        return new ResponseEntity<>(departmentManagerHistoryService.getAllByDepartmentId(departmentId), HttpStatus.OK);
    }

    @Operation(summary = "Retrieve all DepartmentManagerHistory entities by Member id.")
    @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = DepartmentManagerHistoryDto.class),
            mediaType = "application/json")})
    @GetMapping("/members/{memberId}/department-manager-histories")
    public ResponseEntity<List<DepartmentManagerHistoryDto>> getAllByManagerId(
            @PathVariable(value = "memberId") long memberId) {
        return new ResponseEntity<>(departmentManagerHistoryService.getAllByMemeberId(memberId), HttpStatus.OK);
    }

    @Operation(summary = "Retrieve DepartmentManagerHistory entity by id.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = DepartmentManagerHistoryDto.class),
                    mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ErrorDetailsDto.class),
                    mediaType = "application/json")})
    })
    @GetMapping("/department-manager-histories/{id}")
    public ResponseEntity<DepartmentManagerHistoryDto> getById(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(departmentManagerHistoryService.getById(id), HttpStatus.OK);
    }

}
