package com.baseschoolapp.schoolapp.models.Teacher;


public class LeaveHistoyDataModel {
    String day, monthYear, leaveType, duration, status;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonthYear() {
        return monthYear;
    }

    public void setMonthYear(String monthYear) {
        this.monthYear = monthYear;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatusColor() {
        return statusColor;
    }

    public void setStatusColor(int statusColor) {
        this.statusColor = statusColor;
    }

    int statusColor;

    public int getDayBgColor() {
        return dayBgColor;
    }

    public void setDayBgColor(int dayBgColor) {
        this.dayBgColor = dayBgColor;
    }

    int dayBgColor;

    public LeaveHistoyDataModel(int dayBgColor, String day, String monthYear, String leaveType, String duration, String status, int statusColor) {
        this.dayBgColor = dayBgColor;
        this.day = day;
        this.monthYear = monthYear;
        this.leaveType = leaveType;
        this.duration = duration;
        this.status = status;
        this.statusColor = statusColor;
    }

}
