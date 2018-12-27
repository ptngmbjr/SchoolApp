package com.baseschoolapp.schoolapp.models.Student;


public class FeeDataModel {

    boolean flag;
    String fee_name;
    String fee_amout;

    public FeeDataModel(boolean flag, String name, String amount) {
        this.flag = flag;
        this.fee_name = name;
        this.fee_amout = amount;

    }

    public String getFee_name() {
        return fee_name;
    }

    public String getFee_amout() {
        return fee_amout;
    }

    public boolean getFlag() {
        return flag;
    }
}
