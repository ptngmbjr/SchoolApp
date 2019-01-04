package com.baseschoolapp.schoolapp.models.Teacher;


public class ExistingTimeTableDataModel {

    String className, timings;
    int bgColor;
    int fgColor;
    int timingBgColor;

    public int getTimingBgColor() {
        return timingBgColor;
    }

    public void setTimingBgColor(int timingBgColor) {
        this.timingBgColor = timingBgColor;
    }


    public ExistingTimeTableDataModel(String className, String timings, int bgColor, int fgColor, int timingBgColor) {
        this.className = className;
        this.timings = timings;
        this.bgColor = bgColor;
        this.fgColor = fgColor;
        this.timingBgColor = timingBgColor;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTimings() {
        return timings;
    }

    public void setTimings(String timings) {
        this.timings = timings;
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
