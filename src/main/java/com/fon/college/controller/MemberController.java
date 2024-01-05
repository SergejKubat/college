package com.fon.college.controller;

import com.fon.college.payload.MemberDto;
import com.fon.college.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public ResponseEntity<List<MemberDto>> getAll() {
        return new ResponseEntity<>(memberService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberDto> getById(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(memberService.getById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<MemberDto> create(@RequestBody MemberDto departmentDto) {
        return new ResponseEntity<>(memberService.create(departmentDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberDto> update(@PathVariable(value = "id") long id,
                                             @RequestBody MemberDto departmentDto) {
        return new ResponseEntity<>(memberService.update(id, departmentDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") long id) {
        memberService.delete(id);

        return new ResponseEntity<>("Member successfully deleted.", HttpStatus.OK);
    }
}
