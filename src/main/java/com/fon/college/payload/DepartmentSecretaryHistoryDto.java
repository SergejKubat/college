package com.fon.college.payload;

import lombok.Data;

import java.util.Date;

@Data
public class DepartmentSecretaryHistoryDto {

    private long id;

    private long departmentId;

    private long secretaryId;

    private Date startDate;

    private Date endDate;

}
