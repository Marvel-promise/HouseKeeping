package com.wang.housekeeping.controller;

import com.wang.housekeeping.pojo.TbAreas;
import com.wang.housekeeping.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/area")
public class AreaController {
    @Autowired
    private AreaService service;
    @PostMapping("/area")
    public List<TbAreas> getArea(@RequestBody TbAreas areas){
        return service.getArea(areas);
    }
}
