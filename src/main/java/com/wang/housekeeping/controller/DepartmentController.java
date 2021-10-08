package com.wang.housekeeping.controller;

import com.wang.housekeeping.pojo.Department;
import com.wang.housekeeping.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService service;
    @PostMapping("/getAll")
    public HashMap<String,Object> getAll(){
        HashMap<String,Object> hashMap = new HashMap<>();
        ArrayList<Department> arrayList = service.getAll();
        if(arrayList.isEmpty()){
            hashMap.put("status",500);
            hashMap.put("msg","错误查询，没有相应部门");
        }else{
            hashMap.put("status",200);
            hashMap.put("msg","查询成功");
            hashMap.put("dept",arrayList);
        }
        return hashMap;
    }
    @GetMapping("/getOne/{deptId}")
    public HashMap<String,Object> getOne(@PathVariable("deptId")String deptId){
        HashMap<String,Object> hash = new HashMap<>();
        Department department = service.getOne(Integer.parseInt(deptId));
        if (department != null){
            hash.put("status",200);
            hash.put("msg","查询成功");
            hash.put("dept",department);
        }else {
            hash.put("status",500);
            hash.put("msg","错误查询，没有相应部门");
        }
        return hash;
    }
}
