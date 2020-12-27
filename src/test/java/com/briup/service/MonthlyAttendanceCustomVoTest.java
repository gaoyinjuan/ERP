package com.briup.service;

import com.briup.exception.CustomException;
import com.briup.service.impl.SalaryServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MonthlyAttendanceCustomVoTest {
    @Autowired
    private SalaryServiceImpl salaryService = null;
     @Test
    public void test(){
         try {
             salaryService.insertSalaryByAcountAndDate("4","2017-06");
         } catch (CustomException e) {
             e.printStackTrace();
         }
     }
}
