package com.baseschoolapp.schoolapp.models.Student;


public class DashBoardViewDataModel {


    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    String item_name;
    int image;


    public DashBoardViewDataModel(String item_name, int image) {
        this.item_name=item_name;
        this.image=image;
    }


}
