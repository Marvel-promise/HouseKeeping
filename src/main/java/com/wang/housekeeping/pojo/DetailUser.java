package com.wang.housekeeping.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name="detail_user")
public class DetailUser {
    @Column
    Integer userId;
    @Column
    String userCode;
    @Column
    String userPhone;
    @Column
    String userPassword;
    @Column
    String userGender;
    @Column
    String userEmil;
    @Column
    String userName;
    @Column
    String province;
    @Column
    Integer provinceid;
    @Column
    String city;
    @Column
    String area;
    @Column
    String cityid;
    @Column
    String areaid;
    @Column
    String userDetailArea;
}
