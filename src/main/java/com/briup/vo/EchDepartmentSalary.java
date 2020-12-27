package com.briup.vo;

import java.util.List;


public class EchDepartmentSalary {
    //部门名称
    private String department;

    //工资列表：最低工资，平均工资，最高工资
    private List<Double> salary;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Double> getSalary() {
        return salary;
    }

    public void setSalary(List<Double> salary) {
        this.salary = salary;
    }
}
