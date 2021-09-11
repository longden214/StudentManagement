/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;



/**
 *
 * @author admin
 */
public class Course {
    private String maCourse;
    private Date startDate;
    private Date endDate;

    public Course() {
    }

    public Course(String maCourse, Date startDate, Date endDate) {
        this.maCourse = maCourse;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getMaCourse() {
        return maCourse;
    }

    public void setMaCourse(String maCourse) {
        this.maCourse = maCourse;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return maCourse;
    }
    
    
}
