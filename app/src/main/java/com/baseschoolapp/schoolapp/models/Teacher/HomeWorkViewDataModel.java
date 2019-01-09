package com.baseschoolapp.schoolapp.models.Teacher;


public class HomeWorkViewDataModel {


    String hw_sub_name, hw_sub_details, hw_submission_date;
    int hw_sub_color;
    int hw_sub_image;

    public String getHw_sub_name() {
        return hw_sub_name;
    }

    public void setHw_sub_name(String hw_sub_name) {
        this.hw_sub_name = hw_sub_name;
    }

    public String getHw_sub_details() {
        return hw_sub_details;
    }

    public void setHw_sub_details(String hw_sub_details) {
        this.hw_sub_details = hw_sub_details;
    }

    public String getHw_submission_date() {
        return hw_submission_date;
    }

    public void setHw_submission_date(String hw_submission_date) {
        this.hw_submission_date = hw_submission_date;
    }

    public int getHw_sub_color() {
        return hw_sub_color;
    }

    public void setHw_sub_color(int hw_sub_color) {
        this.hw_sub_color = hw_sub_color;
    }

    public int getHw_sub_image() {
        return hw_sub_image;
    }

    public void setHw_sub_image(int hw_sub_image) {
        this.hw_sub_image = hw_sub_image;
    }

    public boolean isSub_checkbox_status() {
        return sub_checkbox_status;
    }

    public void setSub_checkbox_status(boolean sub_checkbox_status) {
        this.sub_checkbox_status = sub_checkbox_status;
    }

    boolean sub_checkbox_status;

    public HomeWorkViewDataModel(String hw_sub_name, String hw_sub_details, String hw_submission_date, int hw_sub_color,
                                 int hw_sub_image,
                                 boolean sub_checkbox_status) {
        this.hw_sub_name=hw_sub_name;
        this.hw_sub_details=hw_sub_details;
        this.hw_submission_date=hw_submission_date;
        this.hw_sub_color=hw_sub_color;
        this.hw_sub_image=hw_sub_image;
        this.sub_checkbox_status=sub_checkbox_status;
    }


}
