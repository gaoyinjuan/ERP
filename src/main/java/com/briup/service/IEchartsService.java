package com.briup.service;

import com.briup.vo.EchDepartmentSalary;
import com.briup.vo.EchEmployeeNums;
import com.briup.vo.EchMonthSalary;
import com.briup.vo.EchSalaryPercent;

import java.util.List;
import java.util.Map;

public interface IEchartsService {
    Map<String,List<EchEmployeeNums>> getEmployeeNums();
    Map<String,List<EchDepartmentSalary>> getDepartmentSalary(String date);
    Map<String,List<EchSalaryPercent>> getSalaryPercent(String date,int state);
    Map<String,List<EchMonthSalary>> getMonthSalary();
}
