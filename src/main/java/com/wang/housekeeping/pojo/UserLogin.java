package com.wang.housekeeping.pojo;

import lombok.Data;

@Data
public class UserLogin {
    String userCode;
    String userPhone;
    String userEmil;
    String pwd;
    String loc;
}
