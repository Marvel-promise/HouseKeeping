package com.wang.housekeeping.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Data
@Table(name="log_user")
public class LogUser {
    @Id
    @KeySql(useGeneratedKeys=true)
    Integer logId;
    @Column
    Integer userId;
    @Column
    String userName;
    @Column
    String loginTime;
    @Column
    String loginLocation;
}
