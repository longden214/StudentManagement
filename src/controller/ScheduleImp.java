/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Schedule;

/**
 *
 * @author admin
 */
public class ScheduleImp implements ISchedule{

    public static Date addDays(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 2);
        return cal.getTime();
    }
    
    @Override
    public List<Schedule> getSchedule(String search) {
        List<Schedule> data = new ArrayList<>();
        ResultSet rs = SqlConnection.executeQuery("{call sp_getListSchedule(?)}", search);
        
        try {
            while (rs.next()) {
                Schedule s = new Schedule();
                s.setId(rs.getInt("Id"));
                s.setIdSubject(rs.getInt("subjectId"));
                s.setIdTeacher(rs.getInt("teacherId"));
                s.setNameSubject(rs.getString("mon"));
                s.setNameTeacher(rs.getString("hoten"));
                s.setIdClass(rs.getString("lop"));
                s.setFrametime(rs.getBoolean("frameTime"));
                s.setStartTime(rs.getTime("startTime"));
                s.setEndTime(rs.getTime("endTime"));
                s.setStartDate(new java.sql.Date(addDays(rs.getDate("startDate")).getTime()));
                s.setEndDate(new java.sql.Date(addDays(rs.getDate("endDate")).getTime()));
                s.setNote(rs.getString("note"));
                
                data.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }

    @Override
    public Schedule find(int id) {
        ResultSet rs = SqlConnection.executeQuery("{call sp_findSchedule(?)}", id);
        
        try {
            while (rs.next()) {
                Schedule s = new Schedule();
                s.setId(rs.getInt("Id"));
                s.setIdSubject(rs.getInt("subjectId"));
                s.setIdTeacher(rs.getInt("teacherId"));
                s.setNameSubject(rs.getString("mon"));
                s.setNameTeacher(rs.getString("hoten"));
                s.setIdClass(rs.getString("lop"));
                s.setFrametime(rs.getBoolean("frameTime"));
                s.setStartTime(rs.getTime("startTime"));
                s.setEndTime(rs.getTime("endTime"));
                s.setStartDate(new java.sql.Date(addDays(rs.getDate("startDate")).getTime()));
                s.setEndDate(new java.sql.Date(addDays(rs.getDate("endDate")).getTime()));
                s.setNote(rs.getString("note"));
                
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public void add(Schedule s) {
        SqlConnection.executeUpdate("{call sp_addSchedule(?,?,?,?,?,?,?,?,?)}", s.getIdSubject(),s.getIdTeacher(),s.getIdClass(),s.isFrametime(),s.getStartTime(),s.getEndTime(),s.getStartDate(),s.getEndDate(),s.getNote());
    }

    @Override
    public void update(Schedule s) {
        SqlConnection.executeUpdate("{call sp_updateSchedule(?,?,?,?,?,?,?,?,?,?)}",s.getId(),s.getIdSubject(),s.getIdTeacher(),s.getIdClass(),s.isFrametime(),s.getStartTime(),s.getEndTime(),s.getStartDate(),s.getEndDate(),s.getNote());
    }

    @Override
    public void delete(int id) {
        SqlConnection.executeUpdate("{call sp_deleteSchedule(?)}",id);
    }
    
}
