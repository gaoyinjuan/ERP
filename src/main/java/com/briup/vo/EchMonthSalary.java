package com.briup.vo;

import java.util.List;


public class EchMonthSalary {
    private String year;
    private List<Double> salary;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<Double> getSalary() {
        return salary;
    }

    public void setSalary(List<Double> salary) {
        this.salary = salary;
    }

    public EchMonthSalary(){}
    public EchMonthSalary(String year, List<Double> salary) {
        this.year = year;
        this.salary = salary;
    }
}
