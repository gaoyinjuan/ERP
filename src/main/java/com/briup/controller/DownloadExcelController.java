package com.briup.controller;

import com.briup.service.IDownloadExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author ZhangTZ
 */
@Controller
public class DownloadExcelController {
    @Autowired
    private IDownloadExcelService downloadExcelService;
    //下载工资表
    @RequestMapping(value = "downloadExcel")
    public void downloadExcel(HttpServletRequest request, HttpServletResponse response,String eAccount,Integer dId,String sTime)  throws Exception{
        downloadExcelService.getSalaryExcel(request,response,eAccount,dId,sTime) ;
    }
}
