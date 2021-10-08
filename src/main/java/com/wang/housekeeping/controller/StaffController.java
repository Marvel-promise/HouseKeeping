package com.wang.housekeeping.controller;

import com.github.pagehelper.PageInfo;
import com.wang.housekeeping.pojo.Staff;
import com.wang.housekeeping.pojo.StaffDetail;
import com.wang.housekeeping.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;
    @GetMapping("/deptId/{deptId}")
    public HashMap<String,Object> getByDepartmentId(@PathVariable("deptId") Integer departmentId, @RequestParam("currentPage") int currentPage, @RequestParam("pageSize")int pageSize){
        HashMap<String,Object> hashMap = new HashMap<>();
        PageInfo<StaffDetail> staffs = staffService.getByDeptId(departmentId,currentPage,pageSize);
        if(staffs.getList().isEmpty()){
            hashMap.put("status",500);
            hashMap.put("msg","该部门还没有员工，在其他部门看看");
        }else{
            hashMap.put("status",200);
            hashMap.put("msg","查询成功");
            hashMap.put("staff",staffs);
        }
        return hashMap;
    }
    @PostMapping("/add")
    public HashMap<String,String> add(@RequestBody Staff staff){
        HashMap<String,String> hashMap = new HashMap<>();
        if (staffService.add(staff) > 0){
            hashMap.put("status","200");
            hashMap.put("msg","添加员工成功");
        }else{
            hashMap.put("status","500");
            hashMap.put("msg","添加失败，请重新添加");
        }
        return  hashMap;
    }
    @PostMapping("/update")
    public HashMap<String,Object> update(@RequestBody Staff staff){
        HashMap<String,Object> hashMap = new HashMap<>();
        StaffDetail update1 = staffService.update(staff);
        if (update1!=null){
            hashMap.put("status","200");
            hashMap.put("msg","修改员工成功");
            hashMap.put("staff",update1);
        }else{
            hashMap.put("status","500");
            hashMap.put("msg","修改失败，请重新添加");
        }
        return  hashMap;
    }
    @GetMapping("/del")
    public HashMap<String,Object> del(@RequestBody Staff staff){
        HashMap<String,Object> hashMap = new HashMap<>();
        PageInfo<StaffDetail> update1 = staffService.del(staff);
        if (!update1.getList().isEmpty()){
            hashMap.put("status","200");
            hashMap.put("msg","修改员工成功");
            hashMap.put("staff",update1);
        }else{
            hashMap.put("status","500");
            hashMap.put("msg","修改失败，请重新添加");
        }
        return  hashMap;
    }
        @GetMapping("/condition/{departmentId}/{provinceId}/{cityId}/{currentPage}/{PageSize}")
        public HashMap<String,Object> condition(@PathVariable("departmentId") String departmentId,
                                                @PathVariable("provinceId") String provinceId,
                                                @PathVariable("cityId") String cityId,
                                                @PathVariable("currentPage") String currentPage,
                                                @PathVariable("PageSize") String pageSize){
        HashMap<String,Object> hashMap = new HashMap<>();
        StaffDetail staff = new StaffDetail();
            int dId = Integer.parseInt(departmentId);
            if(dId != 0){
                staff.setDepartmentId(Integer.parseInt(departmentId));
            }
            dId = Integer.parseInt(provinceId);
            if(dId != 0){
                staff.setProvinceid(Integer.parseInt(provinceId));
            }
            dId = Integer.parseInt(cityId);
            if(dId != 0){
                staff.setCityid(Integer.parseInt(cityId));
            }
            System.out.println(staff);
        PageInfo<StaffDetail> update = staffService.getAllByCondition(staff,Integer.parseInt(currentPage),Integer.parseInt(pageSize));
        if (!update.getList().isEmpty()){
            hashMap.put("status","200");
            hashMap.put("msg","条件查询员工成功");
            hashMap.put("staff",update);
        }else{
            hashMap.put("status","500");
            hashMap.put("msg","查询失败,请重新换条件查询或从稍后查询");
        }
        return  hashMap;
    }
    @PostMapping("/getone")
    public HashMap<String,Object> getone(@RequestBody StaffDetail staffDetail){
        HashMap<String,Object> hashMap = new HashMap<>();
        StaffDetail update1 = staffService.getOne(staffDetail);
        if (update1!=null){
            hashMap.put("status","200");
            hashMap.put("msg","查询成功员工成功");
            hashMap.put("staff",update1);
        }else{
            hashMap.put("status","500");
            hashMap.put("msg","查询失败");
        }
        return  hashMap;
    }
}
