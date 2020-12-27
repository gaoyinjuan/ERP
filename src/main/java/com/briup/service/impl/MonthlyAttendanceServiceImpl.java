package com.briup.service.impl;

import com.briup.dao.MonthlyAttendanceMapper;
import com.briup.bean.MonthlyAttendance;
import com.briup.service.IMonthlyAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MonthlyAttendanceServiceImpl implements IMonthlyAttendanceService {
    @Autowired
    private MonthlyAttendanceMapper monthlyAttendanceMapper;
    public MonthlyAttendance t(int id) {
        return monthlyAttendanceMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteByPrimaryKey(int id) {
        monthlyAttendanceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByQuery(int[] ids) {
        monthlyAttendanceMapper.deleteByQuery(ids);
    }

    @Override
    public MonthlyAttendance selectByPrimaryKey(int id) {
        return monthlyAttendanceMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateByPrimaryKeySelective(MonthlyAttendance monthlyAttendance) {
        monthlyAttendanceMapper.updateByPrimaryKeySelective(monthlyAttendance);
    }
}
