package com.wang.housekeeping.pojo;


import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name="user")
public class User {
    @Id
    @KeySql(useGeneratedKeys=true)
    Integer userId;
    @Column
    String userCode;
    @Column
    String userPhone;
    @Column
    String userEmil;
    @Column
    String userPassword;
    @Column
    String userGender;
    @Column
    String userName;
    @Column
    String userProvinceId;
    @Column
    String userCityId;
    @Column
    String userAreaId;
    @Column
    String userDetailArea;
}
