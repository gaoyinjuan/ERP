package com.briup.dao;

import com.briup.vo.EmployeeCustomVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class EmployeeCustomVoTest {
    @Autowired
    private EmployeeCustomVoMapper employeeCustomVoMapper = null;
    @Test
    public void test(){
        EmployeeCustomVo employeeCustomVo = employeeCustomVoMapper.selectEmployeeById(1);
        System.out.println(employeeCustomVo);
    }
}
