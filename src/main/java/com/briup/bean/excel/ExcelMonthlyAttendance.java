package com.briup.bean.excel;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Date;

/**
 * @Classname ExcelMonthlyAttendance
 * @Description TODO
 * @Date 2020/11/18 0:04
 * @Author ZhangTZ
 * @Version 1.0
 */
public class ExcelMonthlyAttendance {
    @ExcelProperty("员工姓名")
    private String employName;
    @ExcelProperty("员工工号")
    private Integer eId;
    @ExcelProperty("病假天数")
    private Integer sickLeaveNum;
    @ExcelProperty("平时加班小时")
    private Double overtimeHour;
    @ExcelProperty("周末加班小时")
    private Double weekendHour;
    @ExcelProperty("节假日加班小时")
    private Double holidayHour;
    @ExcelProperty("迟到次数")
    private Integer lateNum;
    @ExcelProperty("早退次数")
    private Integer earlyNum;
    @ExcelProperty("缺勤天数")
    private Integer absenceNum;
    @ExcelProperty("出差天数")
    private Integer businessTravelNum;
    @ExcelProperty("事假天数")
    private Integer compassionateLeaveNum;
    @ExcelProperty("出勤年月")
    private Date attendanceTime;

    public String getEmployName() {
        return employName;
    }

    public void setEmployName(String employName) {
        this.employName = employName;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public Integer getSickLeaveNum() {
        return sickLeaveNum;
    }

    public void setSickLeaveNum(Integer sickLeaveNum) {
        this.sickLeaveNum = sickLeaveNum;
    }

    public Double getOvertimeHour() {
        return overtimeHour;
    }

    public void setOvertimeHour(Double overtimeHour) {
        this.overtimeHour = overtimeHour;
    }

    public Double getWeekendHour() {
        return weekendHour;
    }

    public void setWeekendHour(Double weekendHour) {
        this.weekendHour = weekendHour;
    }

    public Double getHolidayHour() {
        return holidayHour;
    }

    public void setHolidayHour(Double holidayHour) {
        this.holidayHour = holidayHour;
    }

    public Integer getLateNum() {
        return lateNum;
    }

    public void setLateNum(Integer lateNum) {
        this.lateNum = lateNum;
    }

    public Integer getEarlyNum() {
        return earlyNum;
    }

    public void setEarlyNum(Integer earlyNum) {
        this.earlyNum = earlyNum;
    }

    public Integer getAbsenceNum() {
        return absenceNum;
    }

    public void setAbsenceNum(Integer absenceNum) {
        this.absenceNum = absenceNum;
    }

    public Integer getBusinessTravelNum() {
        return businessTravelNum;
    }

    public void setBusinessTravelNum(Integer businessTravelNum) {
        this.businessTravelNum = businessTravelNum;
    }

    public Integer getCompassionateLeaveNum() {
        return compassionateLeaveNum;
    }

    public void setCompassionateLeaveNum(Integer compassionateLeaveNum) {
        this.compassionateLeaveNum = compassionateLeaveNum;
    }

    public Date getAttendanceTime() {
        return attendanceTime;
    }

    public void setAttendanceTime(Date attendanceTime) {
        this.attendanceTime = attendanceTime;
    }

    @Override
    public String toString() {
        return "ExcelMonthlyAttendance{" +
                "employName='" + employName + '\'' +
                ", eId=" + eId +
                ", sickLeaveNum=" + sickLeaveNum +
                ", overtimeHour=" + overtimeHour +
                ", weekendHour=" + weekendHour +
                ", holidayHour=" + holidayHour +
                ", lateNum=" + lateNum +
                ", earlyNum=" + earlyNum +
                ", absenceNum=" + absenceNum +
                ", businessTravelNum=" + businessTravelNum +
                ", compassionateLeaveNum=" + compassionateLeaveNum +
                ", attendanceTime=" + attendanceTime +
                '}';
    }
}
