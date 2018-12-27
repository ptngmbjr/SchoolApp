package com.baseschoolapp.schoolapp.models.Student;


public class CalenderEventsModel {


    String date;
    String day;
    String header, details;
    int colorCode;

    public CalenderEventsModel(int colorCode,String date, String day, String header, String details) {
        this.colorCode=colorCode;
        this.date = date;
        this.day = day;
        this.header = header;
        this.details = details;
    }

    public int getColorCode() {
        return colorCode;
    }

    public void setColorCode(int colorCode) {
        this.colorCode = colorCode;
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

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


}
