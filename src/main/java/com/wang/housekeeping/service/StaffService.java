package com.wang.housekeeping.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.housekeeping.mapper.StaffDetailMapper;
import com.wang.housekeeping.mapper.StaffMapper;
import com.wang.housekeeping.pojo.Staff;
import com.wang.housekeeping.pojo.StaffDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {
    @Autowired
    private StaffMapper mapper;
    @Autowired
    private StaffDetailMapper dMapper;
    public PageInfo<StaffDetail> getByDeptId(Integer departmentId, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        StaffDetail detail = new StaffDetail();
        detail.setDepartmentId(departmentId);
        List<StaffDetail> list = dMapper.select(detail);
        return new PageInfo<StaffDetail>(list);
    }
    public PageInfo<StaffDetail> getAll(int currentPage,int pageSize){
        PageHelper.startPage(currentPage,pageSize);
        List<StaffDetail> list = dMapper.selectAll();
        return new PageInfo<StaffDetail>(list);
    }

    public int add(Staff staff) {
        return mapper.insert(staff);
    }

    public StaffDetail update(Staff staff) {
        mapper.updateByPrimaryKey(staff);
        StaffDetail detail = new StaffDetail();
        detail.setStaffId(staff.getStaffId());
        return dMapper.selectOne(detail);
    }

    public PageInfo<StaffDetail> del(Staff staff) {
        PageHelper.startPage(1,10);
        mapper.delete(staff);
        List<StaffDetail> list = dMapper.selectAll();
        return new PageInfo<StaffDetail>(list);
    }
    public PageInfo<StaffDetail> getAllByCondition(StaffDetail staff, int currentPage, int pageSize){
        PageHelper.startPage(currentPage,pageSize);
        List<StaffDetail> list = dMapper.select(staff);
        return new PageInfo<StaffDetail>(list);
    }
    public StaffDetail getOne(StaffDetail staffDetail){
        return dMapper.selectOne(staffDetail);
    }

}
