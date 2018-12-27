package com.baseschoolapp.schoolapp.models.Teacher;


public class HomeWorkAllocationDataModel {


    String student_name;
    String student_id;

    public HomeWorkAllocationDataModel(String student_name, String student_id) {
        this.student_name = student_name;
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }


}
