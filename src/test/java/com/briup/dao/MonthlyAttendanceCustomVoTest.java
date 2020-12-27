package com.briup.dao;

import com.briup.vo.MonthlyAttendanceCustomVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MonthlyAttendanceCustomVoTest {
    @Autowired
    private MonthlyAttendanceCustomVoMapper customVoMapper = null;
    @Test
    public void test(){
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("e_account","");
        map.put("d_id",4);
        map.put("attendance_time","");

        List<MonthlyAttendanceCustomVo> monthlyAttendanceCustomVo
                = customVoMapper.selectMonthlyAttendanceCustomVoMapperByeAccountAnddIdAndTime(map);
        System.out.println(monthlyAttendanceCustomVo.toString());
    }
}
