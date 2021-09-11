/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Attendance;
import model.Mark;
import model.Schedule;

/**
 *
 * @author admin
 */
public class SystemManage {
    public List<Attendance> getInfoStudent(String className){
        List<Attendance> data = new ArrayList<>();
        ResultSet rs = SqlConnection.executeQuery("{call getInfoStudent(?)}",className);

        try {
            while (rs.next()) {
                Attendance a = new Attendance();
                a.setClassName(rs.getString("className"));
                a.setIdStudent(rs.getString("idsv"));
                a.setStudentName(rs.getString("studentName"));
                
                data.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SystemManage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    public void addAttendance(Attendance a){
        SqlConnection.executeUpdate("{call sp_addAttendance(?,?,?,?,?,?)}",a.getIdSchedule(),a.getIdStudent(),a.getCreatedDate(),a.getUpdatedDate(),a.getStatus(),a.getNote());
    }
    
    public void updateAttendance(Attendance a){
        SqlConnection.executeUpdate("{call sp_updateAttendance(?,?,?,?,?,?)}",a.getIdSchedule(),a.getIdStudent(),a.getUpdatedDate(),a.getStatus(),a.getNote(),new java.sql.Date(new java.util.Date().getTime()));
    }
    
    public List<Schedule> getListSchedule(){
        List<Schedule> data = new ArrayList<>();
        
        LocalDate localDate  = LocalDate.now();
        DayOfWeek day = localDate.getDayOfWeek();
        int frametime = 0;
        int thu = day.getValue();
        
        if (thu == 1 || thu == 3 || thu == 5) {
		frametime = 0;
	} else if (thu != 7) {
		frametime = 1;
	} else {
		frametime = -1;
	}
        
        long millis=System.currentTimeMillis();
        
        java.sql.Date date=new java.sql.Date(millis);
        java.sql.Time time = new java.sql.Time(millis);
        
        ResultSet rs = SqlConnection.executeQuery("{call sp_getScheduleToday(?,?,?)}",frametime,time,date);
        
        try {
            while (rs.next()) {
                Schedule s = new Schedule();

                s.setId(rs.getInt("Id"));
                s.setNameSubject(rs.getString("mon"));
                s.setNameTeacher(rs.getString("hoten"));
                s.setIdClass(rs.getString("lop"));
                
                data.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SystemManage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    public List<Attendance> findAttendance(int idSchedule){
        List<Attendance> data = new ArrayList<>();
        
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);
        
        ResultSet rs = SqlConnection.executeQuery("{call sp_editAttendance(?,?)}",idSchedule,date);
        try {
            while (rs.next()) {
                Attendance a = new Attendance();
                a.setIdSchedule(rs.getInt("scheduleId"));
                a.setIdStudent(rs.getString("idsv"));
                a.setStudentName(rs.getString("hoten"));
                a.setCreatedDate(rs.getTimestamp("createdDate"));
                a.setUpdatedDate(rs.getTimestamp("updatedDate"));
                a.setStatus(rs.getString("status"));
                a.setNote(rs.getString("note"));
                
                data.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SystemManage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    public int CountStudent(){
        ResultSet rs = SqlConnection.executeQuery("{call sp_coutStudent()}");
        int count=0;
        try {
            while (rs.next()) {
                count=rs.getInt("countStudent");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SystemManage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
   
    public int CountTeacher(){
        ResultSet rs = SqlConnection.executeQuery("{call sp_countTeacher()}");
        int count=0;
        try {
            while (rs.next()) {
                count=rs.getInt("countTeacher");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SystemManage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
   
    public int CountSubject(){
        ResultSet rs = SqlConnection.executeQuery("{call sp_countSubject()}");
        int count=0;
        try {
            while (rs.next()) {
                count=rs.getInt("countSubject");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SystemManage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
   
    public int CountClass(){
        ResultSet rs = SqlConnection.executeQuery("{call sp_countClass()}");
        int count=0;
        try {
            while (rs.next()) {
                count=rs.getInt("countClass");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SystemManage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
   
    public int CountUser(){
        ResultSet rs = SqlConnection.executeQuery("{call sp_countUser()}");
        int count=0;
        try {
            while (rs.next()) {
                count=rs.getInt("countUser");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SystemManage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
   
    public int CountCourse(){
        ResultSet rs = SqlConnection.executeQuery("{call sp_countCourse()}");
        int count=0;
        try {
            while (rs.next()) {
                count=rs.getInt("countCourse");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SystemManage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
    
    public int CountKQ(String idsv,String kq){
        ResultSet rs = SqlConnection.executeQuery("{call sp_getMakeCountKQ(?,?)}",idsv,kq);
        int count=0;
        try {
            while (rs.next()) {
                count=rs.getInt("count");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SystemManage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
    
    public List<Mark> getMarkStudent(String idsv){
        List<Mark> data = new ArrayList<>();
        ResultSet rs = SqlConnection.executeQuery("{call sp_getMakeStatistical(?)}",idsv);

        try {
            while (rs.next()) {
                Mark m = new Mark();
                m.setMon(rs.getString("mon"));
                m.setDiem(rs.getFloat("diem"));
                m.setType_mark(rs.getString("type_name"));
                m.setLanthi(rs.getInt("lanthi"));
                m.setKetqua(rs.getString("ketqua"));
                
                data.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SystemManage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
}
