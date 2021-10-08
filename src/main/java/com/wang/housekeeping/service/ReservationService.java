package com.wang.housekeeping.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.housekeeping.mapper.ReservationDetailMapper;
import com.wang.housekeeping.mapper.ReservationMapper;
import com.wang.housekeeping.pojo.Reservation;
import com.wang.housekeeping.pojo.ReservationDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationDetailMapper dMapper;
    @Autowired
    private ReservationMapper mapper;
    public PageInfo<ReservationDetail> getAll(int currentPage, int pageSize, ReservationDetail reservationDetail) {
        PageHelper.startPage(currentPage,pageSize);
        List<ReservationDetail> list =dMapper.select(reservationDetail);
        return new PageInfo<ReservationDetail>(list);
    }

    public int add(Reservation reservation) {
        return mapper.insert(reservation);
    }
    public int delete(Reservation reservation) {
        return mapper.delete(reservation);
    }

    public PageInfo<ReservationDetail> getAllByCondition(ReservationDetail reservationDetail, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<ReservationDetail> list =dMapper.select(reservationDetail);
        return new PageInfo<ReservationDetail>(list);
    }
}
