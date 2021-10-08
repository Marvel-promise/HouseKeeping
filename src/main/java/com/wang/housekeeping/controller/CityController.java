package com.wang.housekeeping.controller;

import com.wang.housekeeping.pojo.TbCities;
import com.wang.housekeeping.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService service;
    @PostMapping("/city")
    public List<TbCities> pro_city(@RequestBody TbCities cities){
        System.out.println(cities);
        return service.pro_city(cities);
    }
}
