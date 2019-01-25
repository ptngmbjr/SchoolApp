package com.baseschoolapp.schoolapp.models.Teacher;

import com.baseschoolapp.schoolapp.utils.ROW_TYPE;

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

    public ROW_TYPE getRow_entry_type() {
        return row_entry_type;
    }

    public void setRow_entry_type(ROW_TYPE row_entry_type) {
        this.row_entry_type = row_entry_type;
    }

    ROW_TYPE row_entry_type;
    int keyColor;

    public int getKeyColor() {
        return keyColor;
    }

    public void setKeyColor(int keyColor) {
        this.keyColor = keyColor;
    }

    public int getValColor() {
        return valColor;
    }

    public void setValColor(int valColor) {
        this.valColor = valColor;
    }

    int valColor;

    public KeyValueDataModel(String key, String value, int keyHeight, int valHeight, int keyColor, int valColor, ROW_TYPE row_entry_type) {
        this.key = key;
        this.value = value;
        this.keyHeight = keyHeight;
        this.valHeight = valHeight;
        this.row_entry_type = row_entry_type;
        this.keyColor = keyColor;
        this.valColor = valColor;
    }


}
