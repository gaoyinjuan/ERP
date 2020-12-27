package com.briup.dao;

import com.briup.bean.KeyValue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class KeyValueTest {
    @Autowired
    private KeyValueMapper keyValueMapper;
    @Test
    public void test(){
        KeyValue keyValue = keyValueMapper.selectBykvKey("traffic_pay");
        System.out.println(keyValue.getKvValue());
    }
}
