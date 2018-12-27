package com.baseschoolapp.schoolapp.models.Student;


public class TimeTableDateWiseModel {


    String date;
    String day;
    String bgColor, fgColor;

    public TimeTableDateWiseModel(String date, String day, String bgColor, String fgColor) {
        this.date = date;
        this.day = day;
        this.bgColor = bgColor;
        this.fgColor = fgColor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public String getFgColor() {
        return fgColor;
    }

    public void setFgColor(String fgColor) {
        this.fgColor = fgColor;
    }

}
