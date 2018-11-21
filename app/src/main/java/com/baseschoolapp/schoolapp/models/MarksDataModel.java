package com.baseschoolapp.schoolapp.models;


public class MarksDataModel {


    String name;
    String result;

    int fontSize;
    int color;

    public MarksDataModel(String name, String result, int fontSize, int color) {
        this.name = name;
        this.result = result;
        this.fontSize = fontSize;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }


}
