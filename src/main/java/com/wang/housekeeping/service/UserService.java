package com.wang.housekeeping.service;

import com.wang.housekeeping.mapper.DetailUserMapper;
import com.wang.housekeeping.mapper.UserMapper;
import com.wang.housekeeping.pojo.DetailUser;
import com.wang.housekeeping.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper mapper;
    @Autowired
    DetailUserMapper dMapper;
    public User login(User login_user) {
        return mapper.selectOne(login_user);
    }
    public DetailUser update(User user) {
         mapper.updateByPrimaryKey(user);
         DetailUser dUser = new DetailUser();
         dUser.setUserId(user.getUserId());
         return dMapper.selectOne(dUser);
    }

    public DetailUser adduser(User user) {
        mapper.insert(user);
        DetailUser dUser = new DetailUser();
        dUser.setUserId(user.getUserId());
        return dMapper.selectOne(dUser);
    }

    public DetailUser getone(User user) {
        DetailUser dUser = new DetailUser();
        dUser.setUserId(user.getUserId());
        return dMapper.selectOne(dUser);
    }
}
