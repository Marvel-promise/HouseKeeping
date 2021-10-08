package com.wang.housekeeping.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name="tb_provinces")
public class TbProvinces {
    @Id
    @KeySql(useGeneratedKeys=true)
    Integer id;
    @Column
    Integer provinceid;
    @Column
    String province;
}
