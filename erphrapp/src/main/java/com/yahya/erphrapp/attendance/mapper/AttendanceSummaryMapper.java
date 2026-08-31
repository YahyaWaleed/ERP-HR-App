package com.yahya.erphrapp.attendance.mapper;

import com.yahya.erphrapp.attendance.dto.AttendanceSummaryResponse;
import com.yahya.erphrapp.attendance.entity.AttendanceSummary;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AttendanceSummaryMapper {

    @Mapping(source = "employee.id", target = "empId")
    @Mapping(source = "payrollPeriod.periodCode", target = "periodId")
    AttendanceSummaryResponse toResponse(AttendanceSummary attendanceSummary);
}