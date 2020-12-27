package com.briup.controller;

import com.briup.exception.CustomException;
import com.briup.bean.Employee;
import com.briup.bean.SystemManager;
import com.briup.service.impl.LoginServiceImpl;
import com.briup.utils.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Controller
public class LoginController {
    @Autowired
    private LoginServiceImpl loginService = null;

    @RequestMapping(value = "/changeCode")
    @ResponseBody
    public void getIdentifyingCode(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // 验证码存储在session的identifyingCode，属性中
        CaptchaUtil.outputCaptcha(request, response);
    }

    // 获取员工登陆界面
    @RequestMapping("/")
    public String getLoginPage(){
        return "employee/login.html";
    }

    // 获取管理员登陆界面
    @RequestMapping("/admin")
    public String getAdminLoginPage(){
        return "admin/adminLogin.html";
    }

    @RequestMapping(value = "/employeeLogin")
    @ResponseBody
    public Map<String,String> employeeLogin(Model model, HttpSession httpSession, String username,
                             String password, String identifyingcode)
    {
        String code = (String) httpSession.getAttribute("identifyingCode");
        HashMap<String, String> map = new HashMap<String, String>();
        if(identifyingcode.equalsIgnoreCase(code)){
            Employee employee = null;
            try {
                employee = loginService.findEmployeeByIdAndPassword(username, password);
            } catch (CustomException e) {
                map.put("msg",e.getMessage());
                map.put("status","500");
                return map;
            }
            // 保存到session
            httpSession.setAttribute("employeeId",employee.geteId());
            map.put("url","/ssm_esms/loginSuccess");
            map.put("msg","成功");
            map.put("status","200");
            return map;
        }else{
            map.put("msg","验证码错误");
            map.put("status","0");
            return map;
        }
    }

    @RequestMapping(value = "/loginSuccess")
    public String loginSucceses(Model model) throws Exception
    {
        return "employee/index.html";
    }

    @RequestMapping(value = "/adminLogin")
    @ResponseBody
    public Map<String,String> adminLogin(Model model, HttpSession httpSession, String username,
                                            String password, String identifyingcode)
    {
        String code = (String) httpSession.getAttribute("identifyingCode");
        HashMap<String, String> map = new HashMap<String, String>();
        if(identifyingcode.equalsIgnoreCase(code)){
            SystemManager manager = null;
            try {
                 manager = loginService.findSystemManagerByIdAndPassword(username, password);
            } catch (CustomException e) {
                map.put("msg",e.getMessage());
                map.put("status","500");
                return map;
            }
            // 保存到session
            httpSession.setAttribute("admin",manager);
            map.put("url","toPage?url=admin/index.html");
            map.put("msg","成功");
            map.put("status","200");
            return map;
        }else{
            map.put("msg","验证码错误");
            map.put("status","0");
            return map;
        }
    }
    @RequestMapping(value = "/getAdminAccount")
    @ResponseBody
    public String getAdminAccount(HttpSession httpSession){
        SystemManager systemManager = (SystemManager) httpSession.getAttribute("admin");
        return systemManager.getSmAccount();
    }

    @RequestMapping(value = "/getEmployeeAccount")
    @ResponseBody
    public Map<String,String> getEmployeeAccount(HttpSession httpSession){
        Integer id = (Integer) httpSession.getAttribute("employeeId");
        Employee employee = loginService.findEmployeeById(id);
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("account",employee.geteAccount());
        map.put("name",employee.geteName());
        return map;
    }
    @RequestMapping(value = "/logout")
    public String logout(HttpSession httpSession){
        httpSession.removeAttribute("employeeId");
        return "redirect:/";
    }

    @RequestMapping(value = "/logoutAdmin")
    public String logoutAdmin(HttpSession httpSession){
       httpSession.removeAttribute("admin");
       return "redirect:/admin";
    }
}
