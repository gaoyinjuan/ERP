package com.briup.controller;

import com.briup.service.IEchartsService;
import com.briup.vo.EchDepartmentSalary;
import com.briup.vo.EchEmployeeNums;
import com.briup.vo.EchMonthSalary;
import com.briup.vo.EchSalaryPercent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class EchartsController {
    @Autowired
    private IEchartsService echartsService;

    @RequestMapping(value = "/showEmployeeNums")
    @ResponseBody
    public Map<String,List<EchEmployeeNums>> showEmployeeNums(){
        return echartsService.getEmployeeNums();
    }

    @RequestMapping(value = "/showDepartmentSalary")
    @ResponseBody
    public Map<String,List<EchDepartmentSalary>> showDepartmentSalary(String date){
        return echartsService.getDepartmentSalary(date);
    }

    @RequestMapping(value = "/showSalaryPercent")
    @ResponseBody
    public Map<String,List<EchSalaryPercent>> showSalaryPercent(String date,int state){

        return  echartsService.getSalaryPercent(date,state);
    }

    @RequestMapping(value = "/showMonthSalary")
    @ResponseBody
    public Map<String,List<EchMonthSalary>> showMonthSalary(){
        return echartsService.getMonthSalary();
    }

}
