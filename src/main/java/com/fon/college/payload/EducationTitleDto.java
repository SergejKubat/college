package com.fon.college.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EducationTitleDto {
    private long id;
    @NotEmpty
    @Size(max = 100)
    private String title;
}
