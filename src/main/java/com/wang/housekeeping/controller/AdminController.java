package com.wang.housekeeping.controller;

import com.wang.housekeeping.pojo.Admin;
import com.wang.housekeeping.pojo.User;
import com.wang.housekeeping.pojo.UserLog;
import com.wang.housekeeping.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/ad")
public class AdminController {
    @Autowired
    private AdminService service;
    @PostMapping("/login")
    public HashMap<String,Object> login(@RequestBody Admin login_user){
        System.out.println(login_user);
        HashMap<String,Object> hashMap = new HashMap<>();
        Admin user = service.login(login_user);
        if (user != null){
            hashMap.put("status",200);
            hashMap.put("msg","登录成功");
            hashMap.put("login_user",user);
        }else{
            hashMap.put("status",500);
            hashMap.put("msg","用户名或密码错误");
        }
        return hashMap;
    }
}
