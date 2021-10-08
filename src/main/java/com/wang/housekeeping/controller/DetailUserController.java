package com.wang.housekeeping.controller;

import com.wang.housekeeping.pojo.DetailUser;
import com.wang.housekeeping.service.DetailUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/de_user")
public class DetailUserController {
/*    @Autowired
    private DetailUserService service;
    @GetMapping("/one_user/{userId}")
    public HashMap<String,Object> one_user(@PathVariable("userId") Integer userid){
        HashMap<String ,Object> hashMap = new HashMap<>();
        DetailUser detailUser = service.getone(userid);
        hashMap.put("user",detailUser);
        return hashMap;
    }*/
}
