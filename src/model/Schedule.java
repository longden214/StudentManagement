/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author admin
 */
public class Schedule {
    private int id;
    private int idSubject;
    private int idTeacher;
    private String idClass;
    private boolean frametime;
    private Time startTime;
    private Time endTime;
    private Date startDate;
    private Date endDate;
    private String note;
    private String nameSubject;
    private String nameTeacher;

    public Schedule() {
    }

    public Schedule(int id, int idSubject, int idTeacher, String idClass, boolean frametime, Time startTime, Time endTime, Date startDate, Date endDate, String note, String nameSubject, String nameTeacher) {
        this.id = id;
        this.idSubject = idSubject;
        this.idTeacher = idTeacher;
        this.idClass = idClass;
        this.frametime = frametime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startDate = startDate;
        this.endDate = endDate;
        this.note = note;
        this.nameSubject = nameSubject;
        this.nameTeacher = nameTeacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getIdClass() {
        return idClass;
    }

    public void setIdClass(String idClass) {
        this.idClass = idClass;
    }

    public boolean isFrametime() {
        return frametime;
    }

    public void setFrametime(boolean frametime) {
        this.frametime = frametime;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public String getNameTeacher() {
        return nameTeacher;
    }

    public void setNameTeacher(String nameTeacher) {
        this.nameTeacher = nameTeacher;
    }
    
    
}
