package com.wang.housekeeping.controller;

import com.wang.housekeeping.pojo.TbProvinces;
import com.wang.housekeeping.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/province")
public class ProvinceController {
    @Autowired
    private ProvinceService service;
    @GetMapping("/allProvince")
    public List<TbProvinces> getAllProvince(){
        return service.getAllProvince();
    }
}
