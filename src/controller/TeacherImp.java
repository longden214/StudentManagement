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
import model.Teacher;

/**
 *
 * @author admin
 */
public class TeacherImp implements ITeacher {
    public static Date addDays(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 2);
        return cal.getTime();
    }

    @Override
    public List<Teacher> getTeacher(String name) {
        List<Teacher> result = new ArrayList();
        ResultSet rs = SqlConnection.executeQuery("{call sp_getTeacher()}");
        if(name !=null){
            rs=SqlConnection.executeQuery("{call sp_searchTeacher(?)}", name);
        }
        try {
            while (rs.next()) {
                Teacher t = new Teacher();
                t.setIdgv(rs.getInt("idgv"));
                t.setHoten(rs.getString("hoten"));
                t.setPhone(rs.getString("phone"));
                t.setEmail(rs.getString("email"));
                t.setGender(rs.getBoolean("gender"));
                t.setNgaysinh(new java.sql.Date(addDays(rs.getDate("ngaysinh")).getTime()));
                result.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
                
    }

    @Override
    public void insertTeacher(Teacher t) {
        SqlConnection.executeUpdate("{call sp_insertTeacher(?,?,?,?,?)}", t.getHoten(),t.getPhone(),t.getEmail(),t.getGender(),t.getNgaysinh());
    }

    @Override
    public void updateTeacher(Teacher t) {
        SqlConnection.executeUpdate("{call sp_updateTeacher(?,?,?,?,?,?)}",t.getIdgv(), t.getHoten(),t.getPhone(),t.getEmail(),t.getGender(),t.getNgaysinh());
    }

    @Override
    public void delete(int idgv) {
        SqlConnection.executeUpdate("{call sp_deleteTeacher(?)}", idgv);
    }

    @Override
    public Teacher find(int idgv) {
        ResultSet rs = SqlConnection.executeQuery("{call sp_findTeacher(?)}", idgv);
        try {
            while (rs.next()) {
                Teacher t = new Teacher();
                t.setIdgv(rs.getInt("idgv"));
                t.setHoten(rs.getString("hoten"));
                t.setPhone(rs.getString("phone"));
                t.setEmail(rs.getString("email"));
                t.setGender(rs.getBoolean("gender"));
                t.setNgaysinh(new java.sql.Date(addDays(rs.getDate("ngaysinh")).getTime()));
                return t;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
