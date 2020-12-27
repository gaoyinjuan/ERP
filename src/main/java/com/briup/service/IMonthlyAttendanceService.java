package com.briup.service;

import com.briup.bean.MonthlyAttendance;


public interface IMonthlyAttendanceService {
    void deleteByPrimaryKey(int id);

    void deleteByQuery(int[] ids);

    MonthlyAttendance selectByPrimaryKey(int id);

    void updateByPrimaryKeySelective(MonthlyAttendance monthlyAttendance);
}
