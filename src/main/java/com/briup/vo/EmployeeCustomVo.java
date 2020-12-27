package com.briup.vo;

import com.briup.bean.Department;
import com.briup.bean.Employee;
import com.briup.bean.Position;
import com.briup.bean.RankBonus;


public class EmployeeCustomVo {
    private Employee employee;
    private RankBonus rankBonus;
    private Position position;
    private Department department;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public RankBonus getRankBonus() {
        return rankBonus;
    }

    public void setRankBonus(RankBonus rankBonus) {
        this.rankBonus = rankBonus;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "EmployeeCustomVo{" +
                "employee=" + employee +
                ", rankBonus=" + rankBonus +
                ", position=" + position +
                ", department=" + department +
                '}';
    }
}
