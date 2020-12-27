package com.briup.service.impl;

import com.alibaba.excel.EasyExcel;
import com.briup.bean.excel.ExcelMonthlyAttendance;
import com.briup.dao.EmployeeMapper;
import com.briup.dao.MonthlyAttendanceMapper;
import com.briup.dao.SalaryMapper;
import com.briup.listener.MonthlyAttendanceListener;
import com.briup.service.IImportDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class ImportDataServiceImpl implements IImportDataService {
    @Autowired
    private MonthlyAttendanceMapper monthlyAttendanceMapper;
    @Autowired
    private SalaryMapper salaryMapper;
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public String insertMATable(MultipartFile excel) {
        String fileName = excel.getOriginalFilename();
        //限制上传文件的类型
        if (fileName.endsWith(".xls")) {
            String path = "D://Sexcel/monthly_attendance_table/";
            File fileDirectory = new File(path);
            if (!fileDirectory.exists())
                fileDirectory.mkdirs();
            File file = new File(path, fileName);
            //完成上传
            try {
                excel.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            MonthlyAttendanceListener listener = new MonthlyAttendanceListener(employeeMapper,monthlyAttendanceMapper);
            EasyExcel.read(file, ExcelMonthlyAttendance.class,listener).sheet().doRead();
            return "导入成功";
        } else {
            return "只能导入工作表 (.xls)，请检查文件是否正确";
        }
    }


}
