package com.baseschoolapp.schoolapp.models;


public class ExamAndResultDataModel {

    String unitTestName;
    String unitTestStartDate;
    String grade;
    String testTitle;
    String testDetails;
    int colorCode;

    public boolean isHeader() {
        return isHeader;
    }

    public void setHeader(boolean header) {
        isHeader = header;
    }

    boolean isHeader;

    public ExamAndResultDataModel(String unitTestName, String unitTestStartDate, String grade, String testTitle, String testDetails, boolean isHeader, int colorCode) {
        this.unitTestName = unitTestName;
        this.unitTestStartDate = unitTestStartDate;
        this.grade = grade;
        this.testTitle = testTitle;
        this.testDetails = testDetails;
        this.isHeader = isHeader;
        this.colorCode = colorCode;
    }

    public String getUnitTestName() {
        return unitTestName;
    }

    public void setUnitTestName(String unitTestName) {
        this.unitTestName = unitTestName;
    }

    public String getUnitTestStartDate() {
        return unitTestStartDate;
    }

    public void setUnitTestStartDate(String unitTestStartDate) {
        this.unitTestStartDate = unitTestStartDate;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getTestTitle() {
        return testTitle;
    }

    public void setTestTitle(String testTitle) {
        this.testTitle = testTitle;
    }

    public String getTestDetails() {
        return testDetails;
    }

    public void setTestDetails(String testDetails) {
        this.testDetails = testDetails;
    }

    public int getColorCode() {
        return colorCode;
    }

    public void setColorCode(int colorCode) {
        this.colorCode = colorCode;
    }


}
