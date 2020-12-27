package com.briup.service;

import com.briup.exception.CustomException;
import com.briup.service.impl.LoginServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestLoginService {
    @Autowired
    private LoginServiceImpl loginService = null;
    @Test
    public void testFindEmployeeByIdAndPassword() throws Exception {
        loginService.findEmployeeByIdAndPassword("1","1");
    }

    @Test
    public void testFindSystemManagerByIdAndPassword()  {
        try {
            loginService.findSystemManagerByIdAndPassword("admin","1");
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }
}
