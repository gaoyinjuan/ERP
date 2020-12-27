package com.briup.dao;

import com.briup.vo.MonthlyAttendanceCustomVo;

import java.util.List;
import java.util.Map;

public interface  MonthlyAttendanceCustomVoMapper {
    public List<MonthlyAttendanceCustomVo>
    selectMonthlyAttendanceCustomVoMapperByeAccountAnddIdAndTime(Map<String,Object> map);

    MonthlyAttendanceCustomVo selectVoByPrimaryKey(int id);
}
