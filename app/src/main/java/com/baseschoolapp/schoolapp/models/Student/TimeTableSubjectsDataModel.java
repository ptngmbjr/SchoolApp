package com.baseschoolapp.schoolapp.models.Student;


public class TimeTableSubjectsDataModel {


    int image;
    String header, footer, time;
    int bgcolor;


    public TimeTableSubjectsDataModel(int image,
                                      String header, String footer, String time,
                                      int bgcolor
    ) {
        this.image = image;
        this.header = header;
        this.footer = footer;
        this.time = time;
        this.bgcolor = bgcolor;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getBgcolor() {
        return bgcolor;
    }

    public void setBgcolor(int bgcolor) {
        this.bgcolor = bgcolor;
    }

}
