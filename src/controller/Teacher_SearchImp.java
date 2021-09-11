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
import model.Teacher_Search;

/**
 *
 * @author admin
 */
public class Teacher_SearchImp implements ITeacher_Search{
    public static Date addDays(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 2);
        return (Date) cal.getTime();
    }

    @Override
    public List<Teacher_Search> getTeacher_Search(String name) {
        List<Teacher_Search> result = new ArrayList();
        ResultSet rs = SqlConnection.executeQuery("{call sp_getTeacherSearch()}");
        if(name !=null){
            rs=SqlConnection.executeQuery("{call sp_SearchTeacherSearch(?)}", name);
        }
        try {
            while (rs.next()) {
                Teacher_Search t = new Teacher_Search();
                t.setIdgv(rs.getInt("idgv"));
                t.setHoten(rs.getString("hoten"));
                t.setPhone(rs.getString("phone"));
                t.setEmail(rs.getString("email"));
                t.setGender(rs.getBoolean("gender"));
                t.setNgaysinh(new java.sql.Date(addDays(rs.getDate("ngaysinh")).getTime()));
                t.setNumber_Class(rs.getString("number_Class"));
                result.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
                
    }
}
