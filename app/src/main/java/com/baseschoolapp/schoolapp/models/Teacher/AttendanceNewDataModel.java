package com.baseschoolapp.schoolapp.models.Teacher;

import com.baseschoolapp.schoolapp.utils.ROW_TYPE;

public class AttendanceNewDataModel {


    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    String image;
    boolean selected;

    public AttendanceNewDataModel(String image, String name, boolean selected) {
        this.image = image;
        this.name = name;
        this.selected = selected;
    }


}
