package com.baseschoolapp.schoolapp.models.Student;


public class FeeHistoryDataModel {

    String s_no;
    String receipt_no;
    String date;
    String amout;

    public FeeHistoryDataModel(String s_no, String receipt_no, String date, String amout) {
        this.s_no = s_no;
        this.receipt_no = receipt_no;
        this.date = date;
        this.amout = amout;
    }

    public String getS_no() {
        return s_no;
    }

    public void setS_no(String s_no) {
        this.s_no = s_no;
    }

    public String getReceipt_no() {
        return receipt_no;
    }

    public void setReceipt_no(String receipt_no) {
        this.receipt_no = receipt_no;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmout() {
        return amout;
    }

    public void setAmout(String amout) {
        this.amout = amout;
    }


}
