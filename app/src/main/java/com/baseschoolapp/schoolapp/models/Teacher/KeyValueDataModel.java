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

    public KeyValueDataModel(String subject_name, String id) {
        this.key = subject_name;
        this.value = id;
    }


}
