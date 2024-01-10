package com.fon.college.payload;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SubjectDto {

    private long id;

    private long departmentId;

    @NotEmpty
    @Size(max = 200)
    private String name;

    @Min(value = 1)
    private int espb;

}
