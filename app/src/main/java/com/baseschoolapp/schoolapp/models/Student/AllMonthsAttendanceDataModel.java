package com.baseschoolapp.schoolapp.models.Student;


public class AllMonthsAttendanceDataModel {

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public String getPresent_val() {
        return present_val;
    }

    public void setPresent_val(String present_val) {
        this.present_val = present_val;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    String monthName;
    String present_val;
    String percentage;

    public AllMonthsAttendanceDataModel(String monthName, String present_val, String percentage) {
        this.monthName = monthName;
        this.present_val = present_val;
        this.percentage = percentage;
    }


}
