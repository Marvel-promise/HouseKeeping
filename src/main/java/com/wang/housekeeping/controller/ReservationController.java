package com.wang.housekeeping.controller;

import com.github.pagehelper.PageInfo;
import com.wang.housekeeping.pojo.Reservation;
import com.wang.housekeeping.pojo.ReservationDetail;
import com.wang.housekeeping.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    private ReservationService service;
    @GetMapping("/getAllByPage/{currentPage}/{pageSize}/{reservationUserId}")
    public HashMap<String,Object> getAllByPage(@PathVariable("currentPage") String currentPage, @PathVariable("pageSize")String pageSize,@PathVariable("reservationUserId")String reservationUserId){
        HashMap<String,Object> hashMap = new HashMap<>();
        ReservationDetail reservationDetail = new ReservationDetail();
        reservationDetail.setReservationUserId(Integer.parseInt(reservationUserId));
        PageInfo<ReservationDetail> staffs = service.getAll(Integer.parseInt(currentPage),Integer.parseInt(pageSize),reservationDetail);
        if(staffs.getList().isEmpty()){
            hashMap.put("status",500);
            hashMap.put("msg","查询出错");
        }else{
            hashMap.put("status",200);
            hashMap.put("msg","查询成功");
            hashMap.put("staff",staffs);
        }
        return hashMap;
    }
    @PostMapping("/add")
    public HashMap<String,Object> add(@RequestBody Reservation reservation){
        HashMap<String,Object> hashMap = new HashMap<>();
        if(service.add(reservation)>0){
            hashMap.put("status",200);
            hashMap.put("msg","添加成功");
        }else{
            hashMap.put("status",500);
            hashMap.put("msg","添加失败，请重新添加");
        }
        return hashMap;
    }
    @PostMapping("/delete")
    public HashMap<String,Object> delete(@RequestBody Reservation reservation){
        HashMap<String,Object> hashMap = new HashMap<>();
        if(service.delete(reservation)>0){
            hashMap.put("status",200);
            hashMap.put("msg","取消成功");
        }else{
            hashMap.put("status",500);
            hashMap.put("msg","取消失败，请重新添加");
        }
        return hashMap;
    }
    @PostMapping("/condition")
    public HashMap<String,Object> getAllByPage(@RequestBody ReservationDetail reservationDetail ,@RequestParam("currentPage") int currentPage, @RequestParam("pageSize")int pageSize){
        HashMap<String,Object> hashMap = new HashMap<>();
        PageInfo<ReservationDetail> staffs = service.getAllByCondition(reservationDetail,currentPage,pageSize);
        if(staffs.getList().isEmpty()){
            hashMap.put("status",500);
            hashMap.put("msg","查询出错");
        }else{
            hashMap.put("status",200);
            hashMap.put("msg","查询成功");
            hashMap.put("staff",staffs);
        }
        return hashMap;
    }
}
