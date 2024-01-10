package com.fon.college.payload;

import lombok.Data;

import java.util.Date;

@Data
public class AcademicTitleHistoryDto {

    private long id;

    private long memberId;

    private long academicTitleId;

    private long scientificFieldId;

    private Date startDate;

    private Date endDate;

}
