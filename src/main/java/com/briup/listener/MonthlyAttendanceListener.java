package com.briup.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.briup.bean.Employee;
import com.briup.bean.excel.ExcelMonthlyAttendance;
import com.briup.bean.MonthlyAttendance;
import com.briup.dao.EmployeeMapper;
import com.briup.dao.MonthlyAttendanceMapper;
import com.briup.exception.CustomException;
import org.springframework.beans.BeanUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname MonthlyAttendanceListerer
 * @Description TODO
 * @Date 2020/11/17 21:46
 * @Author ZhangTZ
 * @Version 1.0
 */
public class MonthlyAttendanceListener extends AnalysisEventListener<ExcelMonthlyAttendance> {


    private EmployeeMapper employeeMapper;

    private MonthlyAttendanceMapper monthlyAttendanceMapper;

    public MonthlyAttendanceListener(EmployeeMapper employeeMapper, MonthlyAttendanceMapper monthlyAttendanceMapper) {
        this.employeeMapper = employeeMapper;
        this.monthlyAttendanceMapper = monthlyAttendanceMapper;
    }
    @Override
    public void invoke(ExcelMonthlyAttendance monthlyAttendance, AnalysisContext analysisContext) {
        if(monthlyAttendance==null){
            throw new RuntimeException("表格数据为空");
        }
        List<ExcelMonthlyAttendance> monthlyAttendanceList=new ArrayList<ExcelMonthlyAttendance>();
        monthlyAttendanceList.add(monthlyAttendance);
        for (ExcelMonthlyAttendance temp : monthlyAttendanceList) {
            Integer count = employeeMapper.isExistEmployee(temp.geteId()+"");
            //如果不存在此员工
            if (count == 0){
                throw new CustomException("不存在员工工号为" + temp.geteId() + "，请检查导入的excel文件");
            }
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        for (ExcelMonthlyAttendance temp : monthlyAttendanceList) {
            MonthlyAttendance attendance = new MonthlyAttendance();
            BeanUtils.copyProperties(temp,attendance);
            int eId = employeeMapper.selectEidByEaccount(attendance.geteId()+"");
            Employee employee = new Employee();
            employee.seteId(eId);
            attendance.setEmployee(employee);
            MonthlyAttendance mon = new MonthlyAttendance();
            mon = monthlyAttendanceMapper.selectByeIdAndDate(attendance.getEmployee().geteId(),dateFormat.format(temp.getAttendanceTime()));
            if(mon ==null) {
                monthlyAttendanceMapper.insert(attendance);
            }
            else{
                attendance.setMaId(mon.getMaId());
                monthlyAttendanceMapper.updateByPrimaryKeySelective(attendance);
            }
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {


    }
}
