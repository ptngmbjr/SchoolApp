package com.baseschoolapp.schoolapp.models.Teacher;


public class KeyValueDataModel {


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    String key;
    String value;
    int keyHeight;

    public int getKeyHeight() {
        return keyHeight;
    }

    public void setKeyHeight(int keyHeight) {
        this.keyHeight = keyHeight;
    }

    public int getValHeight() {
        return valHeight;
    }

    public void setValHeight(int valHeight) {
        this.valHeight = valHeight;
    }

    int valHeight;


    public KeyValueDataModel(String subject_name, String id, int keyHeight, int valHeight) {
        this.key = subject_name;
        this.value = id;
        this.keyHeight = keyHeight;
        this.valHeight = valHeight;
    }


}
