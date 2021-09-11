/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author admin
 */
public class Attendance {
    private String className;
    private String idStudent;
    private String studentName;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private String status;
    private String note;
    private int idSchedule;

    public Attendance() {
    }

    public Attendance(String className, String idStudent, String studentName, Timestamp createdDate, Timestamp updatedDate, String status, String note, int idSchedule) {
        this.className = className;
        this.idStudent = idStudent;
        this.studentName = studentName;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.status = status;
        this.note = note;
        this.idSchedule = idSchedule;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(int idSchedule) {
        this.idSchedule = idSchedule;
    }

    
    
}
