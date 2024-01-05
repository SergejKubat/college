package com.fon.college.payload;

import lombok.Data;

import java.util.Date;

@Data
public class AcademicTitleHistoryDto {
    private long id;
    private Date startDate;
    private Date endDate;
}
