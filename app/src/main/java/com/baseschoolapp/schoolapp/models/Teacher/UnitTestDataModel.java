package com.baseschoolapp.schoolapp.models.Teacher;


import com.baseschoolapp.schoolapp.utils.ROW_TYPE;

public class UnitTestDataModel {

    public int getImagePath() {
        return imagePath;
    }

    public void setImagePath(int imagePath) {
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    int imagePath;

    public int getHeaderId() {
        return headerId;
    }

    public void setHeaderId(int headerId) {
        this.headerId = headerId;
    }

    int headerId;
    String name;
    String rollNo;
    String marks;
    String grade;

    public ROW_TYPE getType() {
        return type;
    }

    public void setType(ROW_TYPE type) {
        this.type = type;
    }

    ROW_TYPE type;

    public boolean isEditMode() {
        return inEditMode;
    }

    public void setEditMode(boolean editMode) {
        this.inEditMode = editMode;
    }

    boolean inEditMode;

    public UnitTestDataModel(int image, String name, String rollNo, String marks, String grade, ROW_TYPE type, int headerId, boolean inEditMode) {
        this.imagePath = image;
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
        this.grade = grade;
        this.type = type;
        this.headerId = headerId;
        this.inEditMode = inEditMode;
    }


}
