package com.baseschoolapp.schoolapp.models.Teacher;


public class HomeWorkStatutesModel {

    String name;
    int count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    int color;

    public HomeWorkStatutesModel(String name, int count, int color) {
        this.name = name;
        this.count = count;
        this.color = color;
    }

}
