package com.baseschoolapp.schoolapp.models;


public class NewsDataModel {

    String title;
    String details;

    public NewsDataModel(String title, String details) {
        this.title=title;
        this.details=details;

    }

    public String gettitle() {
        return title;
    }

    public String getdetails() {
        return details;
    }
}
