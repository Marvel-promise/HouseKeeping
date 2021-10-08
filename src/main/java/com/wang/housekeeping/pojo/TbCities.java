package com.wang.housekeeping.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name="tb_cities")
public class TbCities {
    @Id
    @KeySql(useGeneratedKeys=true)
    Integer id;
    @Column
    Integer cityid;
    @Column
    String city;
    @Column
    Integer provinceid;
}
