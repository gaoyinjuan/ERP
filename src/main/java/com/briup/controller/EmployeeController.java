package com.briup.controller;

import com.briup.dao.EmployeeCustomVoMapper;
import com.briup.bean.Employee;
import com.briup.service.EmployeeService;
import com.briup.utils.MD5Utils;
import com.briup.vo.EmployeeCustomVo;
import com.briup.vo.EmployeePages;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeCustomVoMapper employeeCustomVoMapper = null;


    @RequestMapping("/findSelective")
    @ResponseBody
    public EmployeePages findSelective(
            @RequestParam(value="page", defaultValue="1")int pageNum,
            @RequestParam(value="limit", defaultValue="5") int limit,
            @RequestParam(value="e_account", defaultValue="") String e_account,
            @RequestParam(value="e_name", defaultValue="") String e_name,
            @RequestParam(value="d_id", defaultValue="0") int d_id) throws Exception {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("e_account",e_account);
        map.put("e_name",e_name);
        map.put("d_id",d_id);
        //pageNum:起始页面  pageSize:每页的大小
        PageHelper.startPage(pageNum,limit);
        //查找条件，一定要紧跟在startPage后
        List<EmployeeCustomVo> list =
                employeeCustomVoMapper.selectEmployeeSelective(map);
//        System.out.println(list.get(0).getMonthlyAttendance().getAttendanceTime()+"========================");
        PageInfo pageResult = new PageInfo(list);

        //设置前台需要的数据
        EmployeePages employeePages = new EmployeePages();
        employeePages.setCode(0);
        employeePages.setMsg("");
        employeePages.setCount((int) pageResult.getTotal());
        employeePages.setData(pageResult.getList());
        return employeePages;
    }

    /**
     * 查找一个
     * @param id
     * @return
     */
    @RequestMapping("/selectVoByPrimaryKey")
    @ResponseBody
    public EmployeeCustomVo selectVoByPrimaryKey(int id) {
        EmployeeCustomVo monthlyAttendanceCustomVo = new EmployeeCustomVo();
        monthlyAttendanceCustomVo = employeeCustomVoMapper.selectVoByPrimaryKey(id);
        return monthlyAttendanceCustomVo;
    }


    @RequestMapping("/add")
    @ResponseBody
    public int add(String eAccount,
                   String eName,
                   String ePassword,
                   String eIdcard,
                   int rbId,
                   String eSex,
                   String eBirthday,
                   String eDagree,
                   int dId,
                   int pId,
                   String eEntryTime,
                   double eBasePay,
                   String ePhone,
                   String eEmail,
                   String eUrgentPerson,
                   String eUrgentPhone,
                   String eHometown,
                   String headPath) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        //检测工号是否相同
        //查找是否同名
        Employee e = employeeService.findByeAccount(eAccount);
        if(e != null) {
            return 0;
        } else {
            Employee employee = new Employee();
            employee.seteAccount(eAccount);
            employee.seteName(eName);
            employee.setePassword(MD5Utils.encodeByMD5(ePassword));
            employee.seteIdcard(eIdcard);
            employee.seteRank(rbId);
            employee.seteSex(eSex);
            employee.seteBirthday(format.parse(eBirthday));
            employee.seteDagree(eDagree);
            employee.setdId(dId);
            employee.setpId(pId);
            employee.seteEntryTime(format.parse(eEntryTime));
            employee.seteBasePay(eBasePay);
            employee.setePhone(ePhone);
            employee.seteEmail(eEmail);
            employee.seteUrgentPerson(eUrgentPerson);
            employee.seteUrgentPhone(eUrgentPhone);
            employee.seteHometown(eHometown);
            employee.seteHeadPath(headPath);
            employee.seteIsdel(1);
            employeeService.insert(employee);
            return 1;
        }


    }



    @RequestMapping("/updateByPrimaryKeySelective")
    @ResponseBody
    public int updateByPrimaryKeySelective(
                   int eId,
                   String eName,
                   String eIdcard,
                   int rbId,
                   String eSex,
                   String eBirthday,
                   String eDagree,
                   int dId,
                   int pId,
                   String eEntryTime,
                   double eBasePay,
                   String ePhone,
                   String eEmail,
                   String eUrgentPerson,
                   String eUrgentPhone,
                   String eHometown,
                   String headPath) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Employee employee = new Employee();
        employee.seteId(eId);
        employee.seteName(eName);
        employee.seteIdcard(eIdcard);
        employee.seteRank(rbId);
        employee.seteSex(eSex);
        employee.seteBirthday(format.parse(eBirthday));
        employee.seteDagree(eDagree);
        employee.setdId(dId);
        employee.setpId(pId);
        employee.seteEntryTime(format.parse(eEntryTime));
        employee.seteBasePay(eBasePay);
        employee.setePhone(ePhone);
        employee.seteEmail(eEmail);
        employee.seteUrgentPerson(eUrgentPerson);
        employee.seteUrgentPhone(eUrgentPhone);
        employee.seteHometown(eHometown);
        employee.seteHeadPath(headPath);
        employee.seteIsdel(1);
        employeeService.updateByPrimaryKeySelective(employee);
        return 1;


    }

    /**
     * 删除
     * @param id
     * @throws Exception
     */
    @RequestMapping("/deleteByPrimaryKey")
    @ResponseBody
    public int deleteByPrimaryKey(int id) throws Exception {
        //假删除，设置离职时间
        Employee employee = new Employee();
        employee.seteId(id);
        employee.seteLeaveTime(new Date());
        employee.seteIsdel(0);
        employeeService.updateByPrimaryKeySelective(employee);
        return 1;
    }

    /**
     * 批量删除
     * @param ids
     */
    @RequestMapping("/deleteByQuery")
    @ResponseBody
    public int deleteByQuery (@RequestParam(value = "arr")int[] ids) {
        //假删除
        //如果有id才执行
        if(ids.length > 0) {
            employeeService.deleteByQuery(ids);
        }
        return 1;

    }



}
