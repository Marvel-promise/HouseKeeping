package com.wang.housekeeping.service;

import com.wang.housekeeping.mapper.TbProvinceMapper;
import com.wang.housekeeping.pojo.TbProvinces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceService {
    @Autowired
    TbProvinceMapper mapper;
    public List<TbProvinces> getAllProvince() {
        return mapper.selectAll();
    }
}
