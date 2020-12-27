package com.briup.service;

import com.briup.exception.CustomException;
import com.briup.bean.Employee;
import com.briup.vo.EmployeeCustomVo;
import com.briup.bean.Salary;
import com.briup.bean.SystemManager;

import java.util.List;


public interface IUserInforService {
    public void updateSystemManagePassword(int id, SystemManager systemManager);
    public void updateEmployeePassword(int id, String oldPassword, String newPassword) throws CustomException;
    public EmployeeCustomVo getInforEmployee(int id);
    public int  updateEmploueeById(int id, Employee employee);
    // 查找员工个人的某年工资记录
    public List<Salary> getEmployeeSalaryList(int eId, String year);
}
