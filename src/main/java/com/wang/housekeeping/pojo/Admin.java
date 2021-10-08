package com.wang.housekeeping.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name="ad")
public class Admin {
    @Id
    @KeySql(useGeneratedKeys=true)
    Integer adId;
    @Column
    String adName;
    @Column
    String adCode;
    @Column
    String adPwd;
}
