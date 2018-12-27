package com.baseschoolapp.schoolapp.models.Teacher;


public class SyllabusDrillDownDataModel {

    String id;
    String chapterNo;
    String chapterDesc;
    String status;
    int statusBgColor;

    public SyllabusDrillDownDataModel(String id, String chapterNo, String chapterDesc, String status, int statusBgColor) {
        this.id = id;
        this.chapterNo = chapterNo;
        this.chapterDesc = chapterDesc;
        this.status = status;
        this.statusBgColor = statusBgColor;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChapterNo() {
        return chapterNo;
    }

    public void setChapterNo(String chapterNo) {
        this.chapterNo = chapterNo;
    }

    public String getChapterDesc() {
        return chapterDesc;
    }

    public void setChapterDesc(String chapterDesc) {
        this.chapterDesc = chapterDesc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatusBgColor() {
        return statusBgColor;
    }

    public void setStatusBgColor(int statusBgColor) {
        this.statusBgColor = statusBgColor;
    }


}
