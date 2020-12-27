package com.briup.bean.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.briup.bean.Department;
import com.briup.bean.Employee;

import java.util.Date;

/**
 * @Classname ExcelSalary
 * @Description TODO
 * @Date 2020/11/18 12:20
 * @Author ZhangTZ
 * @Version 1.0
 */
public class ExcelSalary{

    @ExcelProperty("员工工号")
    private String eAccount;
    @ExcelProperty("员工姓名")
    private String employeeName;
    @ExcelProperty("所属部门")
    private String departmentName;
    @DateTimeFormat("yyyy/MM/d")
    @ExcelProperty("日期")
    private Date sTime;
    @ExcelProperty("基本工资")

    //补贴
    private Double basePay;
    @ExcelProperty("餐饮补贴")
    private Double foodPay;
    @ExcelProperty("岗位补贴")
    private Double postPay;
    @ExcelProperty("出差补贴")
    private Double businessTravelPay;
    @ExcelProperty("交通补贴")

    //奖金
    private Double trafficPay;
    @ExcelProperty("工龄奖金")
    private Double workingYearPay;
    @ExcelProperty("职称奖金")
    private Double rankPay;
    @ExcelProperty("加班奖金")
    private Double overtimePay;
    @ExcelProperty("全勤奖金")
    private Double fullAttendancePay;

   //五险一金
    @ExcelProperty("养老保险")
    private Double persionPay;
    @ExcelProperty("医疗保险")
    private Double medicalPay;
    @ExcelProperty("失业保险")
    private Double unemploymentPay;
    @ExcelProperty("工伤保险")
    private Double injuryPay;
    @ExcelProperty("生育保险")
    private Double birthPay;
    @ExcelProperty("住房公积金")


    private Double housingPay;
    @ExcelProperty("迟到扣额")
    private Double latePay;
    @ExcelProperty("早退扣额")
    private Double earlyPay;

    @ExcelProperty("病假扣额")
    private Double sickPay;
    @ExcelProperty("事假扣额")
    private Double thingPay;
    @ExcelProperty("个人所得税")
    private Double individualIncomeTax;

    @ExcelProperty("补发金额")
    private Double rissuePay;
    @ExcelProperty("应发工资")
    private Double shouldPay;
    @ExcelProperty("实发工资")
    private Double actualPay;

    @ExcelProperty("状态")
    private String sState;

    public String geteAccount() {
        return eAccount;
    }

    public void seteAccount(String eAccount) {
        this.eAccount = eAccount;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Date getsTime() {
        return sTime;
    }

    public void setsTime(Date sTime) {
        this.sTime = sTime;
    }

    public Double getBasePay() {
        return basePay;
    }

    public void setBasePay(Double basePay) {
        this.basePay = basePay;
    }

    public Double getFoodPay() {
        return foodPay;
    }

    public void setFoodPay(Double foodPay) {
        this.foodPay = foodPay;
    }

    public Double getPostPay() {
        return postPay;
    }

    public void setPostPay(Double postPay) {
        this.postPay = postPay;
    }

    public Double getWorkingYearPay() {
        return workingYearPay;
    }

    public void setWorkingYearPay(Double workingYearPay) {
        this.workingYearPay = workingYearPay;
    }

    public Double getRankPay() {
        return rankPay;
    }

    public void setRankPay(Double rankPay) {
        this.rankPay = rankPay;
    }

    public Double getTrafficPay() {
        return trafficPay;
    }

    public void setTrafficPay(Double trafficPay) {
        this.trafficPay = trafficPay;
    }

    public Double getPersionPay() {
        return persionPay;
    }

    public void setPersionPay(Double persionPay) {
        this.persionPay = persionPay;
    }

    public Double getMedicalPay() {
        return medicalPay;
    }

    public void setMedicalPay(Double medicalPay) {
        this.medicalPay = medicalPay;
    }

    public Double getUnemploymentPay() {
        return unemploymentPay;
    }

    public void setUnemploymentPay(Double unemploymentPay) {
        this.unemploymentPay = unemploymentPay;
    }

    public Double getInjuryPay() {
        return injuryPay;
    }

    public void setInjuryPay(Double injuryPay) {
        this.injuryPay = injuryPay;
    }

    public Double getBirthPay() {
        return birthPay;
    }

    public void setBirthPay(Double birthPay) {
        this.birthPay = birthPay;
    }

    public Double getHousingPay() {
        return housingPay;
    }

    public void setHousingPay(Double housingPay) {
        this.housingPay = housingPay;
    }

    public Double getLatePay() {
        return latePay;
    }

    public void setLatePay(Double latePay) {
        this.latePay = latePay;
    }

    public Double getEarlyPay() {
        return earlyPay;
    }

    public void setEarlyPay(Double earlyPay) {
        this.earlyPay = earlyPay;
    }

    public Double getOvertimePay() {
        return overtimePay;
    }

    public void setOvertimePay(Double overtimePay) {
        this.overtimePay = overtimePay;
    }

    public Double getSickPay() {
        return sickPay;
    }

    public void setSickPay(Double sickPay) {
        this.sickPay = sickPay;
    }

    public Double getThingPay() {
        return thingPay;
    }

    public void setThingPay(Double thingPay) {
        this.thingPay = thingPay;
    }

    public Double getBusinessTravelPay() {
        return businessTravelPay;
    }

    public void setBusinessTravelPay(Double businessTravelPay) {
        this.businessTravelPay = businessTravelPay;
    }

    public Double getFullAttendancePay() {
        return fullAttendancePay;
    }

    public void setFullAttendancePay(Double fullAttendancePay) {
        this.fullAttendancePay = fullAttendancePay;
    }

    public Double getRissuePay() {
        return rissuePay;
    }

    public void setRissuePay(Double rissuePay) {
        this.rissuePay = rissuePay;
    }

    public Double getIndividualIncomeTax() {
        return individualIncomeTax;
    }

    public void setIndividualIncomeTax(Double individualIncomeTax) {
        this.individualIncomeTax = individualIncomeTax;
    }

    public Double getShouldPay() {
        return shouldPay;
    }

    public void setShouldPay(Double shouldPay) {
        this.shouldPay = shouldPay;
    }

    public Double getActualPay() {
        return actualPay;
    }

    public void setActualPay(Double actualPay) {
        this.actualPay = actualPay;
    }

    public String getsState() {
        return sState;
    }

    public void setsState(String sState) {
        this.sState = sState;
    }
}
