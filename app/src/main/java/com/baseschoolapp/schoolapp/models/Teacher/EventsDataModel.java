package com.baseschoolapp.schoolapp.models.Teacher;


import com.baseschoolapp.schoolapp.utils.ROW_TYPE;

public class EventsDataModel {

    ROW_TYPE row_type;
    String name;
    String desc;
    String date;
    String day;

    public ROW_TYPE getRow_type() {
        return row_type;
    }

    public void setRow_type(ROW_TYPE row_type) {
        this.row_type = row_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public int getColorCode() {
        return colorCode;
    }

    public void setColorCode(int colorCode) {
        this.colorCode = colorCode;
    }

    String eventType;
    int colorCode;

    public EventsDataModel(ROW_TYPE row_type, String name, String desc, String date, String day, String eventType, int colorCode) {
        this.row_type = row_type;
        this.name = name;
        this.desc = desc;
        this.date = date;
        this.day = day;
        this.eventType = eventType;
        this.colorCode = colorCode;
    }


}
