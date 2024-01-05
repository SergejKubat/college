package com.fon.college.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DepartmentDto {
    private long id;
    @NotEmpty
    @Size(max = 200)
    private String name;
    @NotEmpty
    @Size(max = 100)
    private String shortName;
}
