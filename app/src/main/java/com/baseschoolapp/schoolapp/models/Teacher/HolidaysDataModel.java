package com.baseschoolapp.schoolapp.models.Teacher;


import com.baseschoolapp.schoolapp.utils.ROW_TYPE;

public class HolidaysDataModel {

    String date;
    String day;

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

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    String eventName;

    public HolidaysDataModel(String date, String day, String eventName) {
        this.date = date;
        this.day = day;
        this.eventName = eventName;
    }


}
