package com.wang.housekeeping.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Data
@Table(name="reservation")
public class Reservation {
    @Id
    @KeySql(useGeneratedKeys=true)
    Integer reservationId;
    @Column
    Integer reservationUserId;
    @Column
    Integer reservationDepartmentId;
    @Column
    Integer reservationStaffId;
    @Column
    String workProvinceId;
    @Column
    String workCityId;
    @Column
    String workAreaId;
    @Column
    String workDetailArea;
    @Column
    String status;
    @Column
    String startTime;
    @Column
    String endTime;
}
