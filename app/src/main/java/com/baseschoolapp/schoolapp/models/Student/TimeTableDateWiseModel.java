package com.baseschoolapp.schoolapp.models.Student;


public class TimeTableDateWiseModel {


    String date;
    String day;
    int bgColor, fgColor;

    public TimeTableDateWiseModel(String date, String day, int bgColor, int fgColor) {
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

    public int getBgColor() {
        return bgColor;
    }

    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }

    public int getFgColor() {
        return fgColor;
    }

    public void setFgColor(int fgColor) {
        this.fgColor = fgColor;
    }

}
