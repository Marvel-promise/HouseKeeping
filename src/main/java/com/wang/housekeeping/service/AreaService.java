package com.wang.housekeeping.service;

import com.wang.housekeeping.mapper.AreaMapper;
import com.wang.housekeeping.pojo.TbAreas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaService {
    @Autowired
    private AreaMapper mapper;
    public List<TbAreas> getArea(TbAreas areas) {
        return mapper.select(areas);
    }
}
