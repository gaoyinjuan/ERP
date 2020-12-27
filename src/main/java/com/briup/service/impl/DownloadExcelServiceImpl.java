package com.briup.service.impl;

import com.alibaba.excel.EasyExcel;
import com.briup.bean.Department;
import com.briup.bean.Employee;
import com.briup.bean.excel.ExcelSalary;
import com.briup.dao.DepartmentMapper;
import com.briup.dao.EmployeeMapper;
import com.briup.dao.SalaryMapper;

import com.briup.bean.Salary;
import com.briup.service.IDownloadExcelService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class DownloadExcelServiceImpl implements IDownloadExcelService{
    @Autowired
    private SalaryMapper salaryMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public void getSalaryExcel(HttpServletRequest request, HttpServletResponse response,String eAccount,Integer dId,String sTime)  throws Exception{
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String excelName = URLEncoder.encode("工资表", "UTF-8").replaceAll("\\+", "%20");
        Map map = new HashMap<String,Object>();
        map.put("eAccount",eAccount);
        map.put("dId",dId);
        map.put("sTime",sTime);
        List<Salary> salaries = salaryMapper.selectByEaccountDIdDate(map);
        List<ExcelSalary> excelSalaries=new ArrayList<ExcelSalary>();
        for (Salary salary : salaries) {
            Integer employeeId = salary.geteId();//获取员工id
            Integer departmentId = salary.getdId();//获取部门id
            //查询员工姓名
            Employee employee = employeeMapper.selectByPrimaryKey(employeeId);
            //查询部门
            Department department = departmentMapper.selectByPrimaryKey(departmentId);
            ExcelSalary excelSalary = new ExcelSalary();
            BeanUtils.copyProperties(salary,excelSalary);

            if(salary.getsState()==0){
                excelSalary.setsState("未发放");
            }
            if(salary.getsState()==1){
                excelSalary.setsState("已发放");
            }
            excelSalary.setEmployeeName(employee.geteName());
            excelSalary.seteAccount(employee.geteAccount());
            excelSalary.setDepartmentName(department.getdName());

            excelSalaries.add(excelSalary);
        }
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''"+ excelName + ".xlsx");
        EasyExcel.write(response.getOutputStream(),ExcelSalary.class).sheet().doWrite(excelSalaries);

    }


}
