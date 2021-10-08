package com.wang.housekeeping.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name="staff")
public class Staff {
    @Id
    @KeySql(useGeneratedKeys=true)
    Integer staffId;
    @Column
    String staffName;
    @Column
    String staffCode;
    @Column
    String staffPwd;
    @Column
    String staffProvinceId;
    @Column
    String staffCityId;
    @Column
    String staffAreaId;
    @Column
    String staffPhone;
    @Column
    Integer staffDepartmentid;
    @Column
    String staffDescription;

}
