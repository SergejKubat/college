package com.fon.college.payload;

import lombok.Data;

import java.util.Date;

@Data
public class DepartmentManagerHistoryDto {

    private long id;

    private long departmentId;

    private long managerId;

    private Date startDate;

    private Date endDate;

}
