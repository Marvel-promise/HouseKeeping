package com.wang.housekeeping.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name="department")
public class Department {
   @Id
   @KeySql(useGeneratedKeys=true)
   Integer departmentId;
   @Column
   String departmentName;
   @Column
   String departmentDescription;
}
