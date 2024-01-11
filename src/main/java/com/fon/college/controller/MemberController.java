package com.fon.college.controller;

import com.fon.college.payload.ErrorDetailsDto;
import com.fon.college.payload.MemberDto;
import com.fon.college.service.MemberService;
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

@Tag(name = "Member Controller")
@RestController
@RequestMapping("/api")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @Operation(summary = "Retrieve all Member entities.")
    @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = MemberDto.class),
            mediaType = "application/json")})
    @GetMapping("/members")
    public ResponseEntity<List<MemberDto>> getAll() {
        return new ResponseEntity<>(memberService.getAll(), HttpStatus.OK);
    }

    @Operation(summary = "Retrieve all Member entities by Department id.")
    @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = MemberDto.class),
            mediaType = "application/json")})
    @GetMapping("/departments/{departmentId}/members")
    public ResponseEntity<List<MemberDto>> getAllByDepartmentId(
            @PathVariable(value = "departmentId") long departmentId) {
        return new ResponseEntity<>(memberService.getAllByDepartmentId(departmentId), HttpStatus.OK);
    }

    @Operation(summary = "Retrieve Member entity by id.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = MemberDto.class),
                    mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ErrorDetailsDto.class),
                    mediaType = "application/json")})
    })
    @GetMapping("/members/{id}")
    public ResponseEntity<MemberDto> getById(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(memberService.getById(id), HttpStatus.OK);
    }

    @Operation(summary = "Create new Member entity.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {@Content(schema = @Schema(implementation = MemberDto.class),
                    mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema(implementation = ErrorDetailsDto.class),
                    mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ErrorDetailsDto.class),
                    mediaType = "application/json")})
    })
    @PostMapping("/members")
    public ResponseEntity<MemberDto> create(@RequestBody MemberDto departmentDto) {
        return new ResponseEntity<>(memberService.create(departmentDto), HttpStatus.CREATED);
    }

    @Operation(summary = "Update Member entity by id.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = MemberDto.class),
                    mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema(implementation = ErrorDetailsDto.class),
                    mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ErrorDetailsDto.class),
                    mediaType = "application/json")})
    })
    @PutMapping("/members/{id}")
    public ResponseEntity<MemberDto> update(@PathVariable(value = "id") long id,
                                            @RequestBody MemberDto departmentDto) {
        return new ResponseEntity<>(memberService.update(id, departmentDto), HttpStatus.OK);
    }

    @Operation(summary = "Delete Subject entity by id.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(mediaType = "text/plain")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ErrorDetailsDto.class),
                    mediaType = "application/json")})
    })
    @DeleteMapping("/members/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") long id) {
        memberService.delete(id);

        return new ResponseEntity<>("Member successfully deleted.", HttpStatus.OK);
    }

}
