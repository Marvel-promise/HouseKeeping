package com.wang.housekeeping.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.housekeeping.mapper.LogUserMapper;
import com.wang.housekeeping.mapper.UserLogMapper;
import com.wang.housekeeping.pojo.LogUser;
import com.wang.housekeeping.pojo.UserLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLogService {
    @Autowired
    private UserLogMapper mapper;
    @Autowired
    private LogUserMapper logUserMapper;
    public void addUserLog(UserLog log) {
        mapper.insert(log);
    }

    public PageInfo<LogUser> getByDeptId(Integer userId, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        LogUser logUser = new LogUser();
        logUser.setUserId(userId);
        List<LogUser> list =logUserMapper.select(logUser);
        return new PageInfo<LogUser>(list);
    }
}
