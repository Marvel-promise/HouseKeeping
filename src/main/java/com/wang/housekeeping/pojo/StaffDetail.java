package com.wang.housekeeping.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name="staff_detail")
public class StaffDetail {
    @Column
    Integer staffId;
    @Column
    String staffName;
    @Column
    String staffPhone;
    @Column
    String staffDescription;
    @Column
    Integer areaid;
    @Column
    String area;
    @Column
    Integer cityid;
    @Column
    String city;
    @Column
    Integer provinceid;
    @Column
    String province;
    @Column
    Integer departmentId;
    @Column
    String departmentName;

}
