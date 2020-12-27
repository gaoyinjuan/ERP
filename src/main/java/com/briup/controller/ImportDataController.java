package com.briup.controller;

import com.briup.service.IImportDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;


@Controller
public class ImportDataController {
    @Autowired
    private IImportDataService importDataService;
    @RequestMapping("/importAttendance")
    @ResponseBody
    public Map<String,String> importAttendanceTable1(@RequestParam("file") MultipartFile excel) throws Exception {
        Map<String,String> map = new HashMap<String, String>();
        if (!excel.isEmpty()) {
            String result = importDataService.insertMATable(excel);
            map.put("result",result);
            return map;
        } else {
            map.put("result","导入的文件不存在，请重新选择文件");
            return map;
        }

    }
}
