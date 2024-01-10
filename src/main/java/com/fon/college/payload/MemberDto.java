package com.fon.college.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MemberDto {

    private long id;

    private long departmentId;

    private long academicTitleId;

    private long educationTitleId;

    private long scientificFieldId;

    @NotEmpty
    @Size(max = 100)
    private String firstName;

    @NotEmpty
    @Size(max = 100)
    private String lastName;

}
