package com.wang.housekeeping.service;

import com.wang.housekeeping.mapper.DepartmentMapper;
import com.wang.housekeeping.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentMapper mapper;

    public ArrayList<Department> getAll() {
        return (ArrayList<Department>) mapper.selectAll();
    }

    public Department getOne(int deptId) {
        Department department = new Department();
        department.setDepartmentId(deptId);
        return mapper.selectOne(department);
    }
}
