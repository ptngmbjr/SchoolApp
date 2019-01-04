package com.baseschoolapp.schoolapp.models.Teacher;


public class LeavesSummaryModel {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoOfLeaves() {
        return noOfLeaves;
    }

    public void setNoOfLeaves(int noOfLeaves) {
        this.noOfLeaves = noOfLeaves;
    }

    String name;
    int noOfLeaves;

    public int getBgColor() {
        return bgColor;
    }

    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }

    int bgColor;

    public LeavesSummaryModel(String name, int noOfLeaves, int bgColor) {
        this.name = name;
        this.noOfLeaves = noOfLeaves;
        this.bgColor=bgColor;
    }

}
