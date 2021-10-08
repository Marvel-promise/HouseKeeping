package com.wang.housekeeping.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
@Data
@Table(name="user_log")
public class UserLog {
    @Id
    @KeySql(useGeneratedKeys=true)

    Integer logId;
    @Column
    Integer userId;
    @Column
    String loginTime;
    @Column
    String loginLocation;
}
