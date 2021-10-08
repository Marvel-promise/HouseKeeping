package com.wang.housekeeping.controller;

import com.github.pagehelper.PageInfo;
import com.wang.housekeeping.pojo.LogUser;
import com.wang.housekeeping.pojo.Staff;
import com.wang.housekeeping.service.UserLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/log")
public class LogUserController {
    @Autowired
    private UserLogService service;
    @GetMapping("/logUser/{userId}/{currentPage}/{pageSize}")
    public HashMap<String,Object> getLogByPage(@PathVariable("userId") Integer userId, @PathVariable("currentPage") String currentPage, @PathVariable("pageSize")String pageSize){
        HashMap<String,Object> hashMap = new HashMap<>();
        PageInfo<LogUser> staffs = service.getByDeptId(userId,Integer.parseInt(currentPage),Integer.parseInt(pageSize));
        if(staffs.getList().isEmpty()){
            hashMap.put("status",500);
            hashMap.put("msg","查询出错");
        }else{
            hashMap.put("status",200);
            hashMap.put("msg","查询成功");
            hashMap.put("staff",staffs);
        }
    return hashMap;
    }
}
