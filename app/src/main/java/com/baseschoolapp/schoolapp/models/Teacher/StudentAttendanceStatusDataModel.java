package com.baseschoolapp.schoolapp.models.Teacher;


import com.baseschoolapp.schoolapp.utils.ROW_ENTRY_TYPE;
import com.baseschoolapp.schoolapp.utils.ROW_TYPE;

public class StudentAttendanceStatusDataModel {

    int studentImage;
    String name, rollNo, leaveDates, leaveName;
    ROW_ENTRY_TYPE type;
    boolean attendanceStatus, messageStatus;

    public ROW_TYPE isHeader() {
        return isHeader;
    }

    public void setHeader(ROW_TYPE header) {
        isHeader = header;
    }

    ROW_TYPE isHeader;

    public int getStudentImage() {
        return studentImage;
    }

    public void setStudentImage(int studentImage) {
        this.studentImage = studentImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getLeaveDates() {
        return leaveDates;
    }

    public void setLeaveDates(String leaveDates) {
        this.leaveDates = leaveDates;
    }

    public String getLeaveName() {
        return leaveName;
    }

    public void setLeaveName(String leaveName) {
        this.leaveName = leaveName;
    }

    public ROW_ENTRY_TYPE getType() {
        return type;
    }

    public void setType(ROW_ENTRY_TYPE type) {
        this.type = type;
    }

    public boolean isAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(boolean attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    public boolean isMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(boolean messageStatus) {
        this.messageStatus = messageStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    String message;

    public int getNameColor() {
        return nameColor;
    }

    public void setNameColor(int nameColor) {
        this.nameColor = nameColor;
    }

    public ROW_TYPE getHeaderType() {
        return isHeader;
    }

    public void setIsHeader(ROW_TYPE isHeader) {
        this.isHeader = isHeader;
    }

    int nameColor;

    public StudentAttendanceStatusDataModel(ROW_TYPE isHeader, int studentImage, String name, int nameColor, String rollNo, String leaveDates, int leaveStringColor,
                                            String leaveName,
                                            int leaveNameStringColor, ROW_ENTRY_TYPE type,
                                            boolean attendanceStatus, boolean messageStatus, String message) {

        this.nameColor = nameColor;
        this.isHeader = isHeader;
        this.studentImage = studentImage;
        this.name = name;
        this.rollNo = rollNo;
        this.leaveDates = leaveDates;
        this.leaveName = leaveName;
        this.type = type;
        this.attendanceStatus = attendanceStatus;
        this.messageStatus = messageStatus;
        this.message = message;
    }


}
