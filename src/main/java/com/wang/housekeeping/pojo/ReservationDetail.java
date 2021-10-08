package com.wang.housekeeping.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.sql.Date;

@Data
@Table(name="reservation_detail")
public class ReservationDetail {
    @Column
    Integer reservationId;
    @Column
    Integer reservationUserId;
    @Column
    String userName;
    @Column
    Integer reservationDepartmentId;
    @Column
    String departmentName;
    @Column
    Integer reservationStaffId;
    @Column
    String staffName;
    @Column
    Integer workProvinceId;
    @Column
    String Province;
    @Column
    Integer workAreaId;
    @Column
    String City;
    @Column
    Integer workCityId;
    @Column
    String Area;
    @Column
    String workDetailArea;
    @Column
    String status;
    @Column
    String startTime;
    @Column
    String endTime;
}
