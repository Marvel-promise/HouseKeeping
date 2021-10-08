package com.wang.housekeeping.service;

import com.wang.housekeeping.mapper.CityMapper;
import com.wang.housekeeping.pojo.TbCities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityMapper mapper;
    public List<TbCities> pro_city(TbCities cities) {
        return mapper.select(cities);
    }
}
