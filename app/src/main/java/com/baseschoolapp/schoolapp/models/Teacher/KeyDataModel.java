package com.baseschoolapp.schoolapp.models.Teacher;


public class KeyDataModel {

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    String key;


    public KeyDataModel(String class_name) {
        this.key = class_name;
    }



}
