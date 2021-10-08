package com.wang.housekeeping.service;

import com.wang.housekeeping.mapper.AdminMapper;
import com.wang.housekeeping.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminMapper mapper;
    public Admin login(Admin login_user) {
        return mapper.selectOne(login_user);
    }
}
