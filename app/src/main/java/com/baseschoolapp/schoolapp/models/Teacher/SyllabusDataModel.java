package com.baseschoolapp.schoolapp.models.Teacher;


public class SyllabusDataModel {


    int image;
    int bgColor;
    int fgColor;
    String subjectName;
    String completionStatus;

    public SyllabusDataModel(int image, int bgColor, int fgColor, String subjectName, String completionStatus) {
        this.image = image;
        this.bgColor = bgColor;
        this.fgColor = fgColor;
        this.subjectName = subjectName;
        this.completionStatus = completionStatus;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
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

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getCompletionStatus() {
        return completionStatus;
    }

    public void setCompletionStatus(String completionStatus) {
        this.completionStatus = completionStatus;
    }


}
