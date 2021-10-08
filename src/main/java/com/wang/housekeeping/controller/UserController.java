package com.wang.housekeeping.controller;

import com.wang.housekeeping.pojo.DetailUser;
import com.wang.housekeeping.pojo.User;
import com.wang.housekeeping.pojo.UserLog;
import com.wang.housekeeping.pojo.UserLogin;
import com.wang.housekeeping.service.DetailUserService;
import com.wang.housekeeping.service.UserLogService;
import com.wang.housekeeping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService service;
    @Autowired
    UserLogService logService;
    @Autowired
    private DetailUserService dService;
    @PostMapping("/login")
    public HashMap<String,Object> login(@RequestBody UserLogin login_user){
        HashMap<String,Object> hashMap = new HashMap<>();
        System.out.println(login_user);
        User loginUser = new User();
        if(login_user.getUserCode()!= null){
            loginUser.setUserCode(login_user.getUserCode());
        }else if(login_user.getUserPhone() != null){
            loginUser.setUserPhone(login_user.getUserPhone());
        }else if(login_user.getUserEmil() != null){
            loginUser.setUserEmil(login_user.getUserEmil());
        }
        loginUser.setUserPassword(login_user.getPwd());
        User user = service.login(loginUser);
        if (user != null){
            hashMap.put("status",200);
            hashMap.put("msg","登录成功");
            hashMap.put("login_user",user);
            UserLog log = new UserLog();
            log.setUserId(user.getUserId());
            log.setLoginLocation(login_user.getLoc());
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            log.setLoginTime(df.format(new Date()));
            logService.addUserLog(log);
        }else{
            hashMap.put("status",500);
            hashMap.put("msg","用户名或密码错误");
        }
        return hashMap;
    }
    @GetMapping("/detail/{userId}")
    public HashMap<String,Object> one_user(@PathVariable("userId") String userid){
        HashMap<String ,Object> hashMap = new HashMap<>();
        User user = new User();
        user.setUserId(Integer.parseInt(userid));
        DetailUser detailUser = service.getone(user);
        if (detailUser!=null){
            hashMap.put("status","200");
            hashMap.put("msg","查询成功");
            hashMap.put("user",detailUser);
        }else{
            hashMap.put("status","500");
            hashMap.put("msg","查询失败");
        }
        return hashMap;
    }
    @PostMapping("/update")
    public HashMap<String,Object> update(@RequestBody User user){
        HashMap<String ,Object> hashMap = new HashMap<>();
        DetailUser user1 =  service.update(user);
        if (user1!=null){
            hashMap.put("status","200");
            hashMap.put("msg","修改成功");
            hashMap.put("user",user1);
        }else{
            hashMap.put("status","500");
            hashMap.put("msg","修改失败");
        }
        return hashMap;
    }
    @PostMapping("/add")
    public HashMap<String,Object> add(@RequestBody User user){
        HashMap<String ,Object> hashMap = new HashMap<>();
        DetailUser user1 =  service.adduser(user);
        if (user1!=null){
            hashMap.put("status","200");
            hashMap.put("msg","新添成功");
            hashMap.put("user",user1);
        }else{
            hashMap.put("status","500");
            hashMap.put("msg","新添加失败");
        }
        return hashMap;
    }
    @PostMapping("/getone")
    public HashMap<String,Object> getone(@RequestBody User user){
        HashMap<String ,Object> hashMap = new HashMap<>();
        DetailUser user1 =  service.getone(user);
        if (user1!=null){
            hashMap.put("status","200");
            hashMap.put("msg","新添成功");
            hashMap.put("user",user1);
        }else{
            hashMap.put("status","500");
            hashMap.put("msg","新添加失败");
        }
        return hashMap;
    }
}
