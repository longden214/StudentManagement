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
import model.Course;

/**
 *
 * @author admin
 */
public class CourseImp implements ICourse{
    
    public static Date addDays(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 2);
        return cal.getTime();
    }
    
    @Override
    public List<Course> getCourse(String search) {
        List<Course> data = new ArrayList<>();
        ResultSet rs = SqlConnection.executeQuery("{call sp_getCourse()}");
        
        if (search != null) {
            rs = SqlConnection.executeQuery("{call sp_getFindCourse(?)}",search);
        }
        
        try {
            while (rs.next()) {
                Course c = new Course();
                c.setMaCourse(rs.getString("maCourse"));
                c.setStartDate(new java.sql.Date(addDays(rs.getDate("startDate")).getTime()));
                c.setEndDate(new java.sql.Date(addDays(rs.getDate("endDate")).getTime()));

                data.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }

    @Override
    public Course find(String ma) {
        ResultSet rs = SqlConnection.executeQuery("{call sp_getFCourse(?)}",ma);
       
        try {
            while (rs.next()) {
                Course c = new Course();
                c.setMaCourse(rs.getString("maCourse"));
                c.setStartDate(new java.sql.Date(addDays(rs.getDate("startDate")).getTime()));
                c.setEndDate(new java.sql.Date(addDays(rs.getDate("endDate")).getTime()));
                
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public void addCourse(Course c) {
        SqlConnection.executeUpdate("{call sp_addCourse(?,?,?)}", c.getMaCourse(),c.getStartDate(),c.getEndDate());
    }

    @Override
    public void editCourse(Course c) {
        SqlConnection.executeUpdate("{call sp_editCourse(?,?,?)}", c.getMaCourse(),c.getStartDate(),c.getEndDate());
    }

    @Override
    public void remove(String ma) {
        SqlConnection.executeUpdate("{call sp_removeCourse(?)}",ma);
    }
    
}
