package com.baseschoolapp.schoolapp.models.Teacher;


public class StudentProfileDataModel {

    public String getBtnName() {
        return btnName;
    }

    public void setBtnName(String btnName) {
        this.btnName = btnName;
    }

    String btnName;

    public int getBtnColor() {
        return btnColor;
    }

    public void setBtnColor(int btnColor) {
        this.btnColor = btnColor;
    }

    int btnColor;

    public StudentProfileDataModel(String btnName, int btnColor) {
        this.btnName = btnName;
        this.btnColor = btnColor;
    }

}
