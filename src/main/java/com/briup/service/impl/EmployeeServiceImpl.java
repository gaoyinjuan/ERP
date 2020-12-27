package com.briup.service.impl;

import com.briup.dao.EmployeeMapper;
import com.briup.bean.Employee;
import com.briup.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public void deleteByPrimaryKey(int id) {
        employeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByQuery(int[] ids) {
        for (int i:ids){
            Employee employee = new Employee();
            employee.seteId(i);
            employee.seteLeaveTime(new Date());
            employee.seteIsdel(0);
            employeeMapper.updateByPrimaryKeySelective(employee);
        }
    }

    @Override
    public void insert(Employee employee) {
        employeeMapper.insert(employee);
    }

    @Override
    public Employee findByeAccount(String eAccount) {
        return employeeMapper.findByeAccount(eAccount);
    }

    @Override
    public void updateByPrimaryKeySelective(Employee employee) {
        employeeMapper.updateByPrimaryKeySelective(employee);
    }
}
