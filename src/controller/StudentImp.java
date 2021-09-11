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
import model.Student;

/**
 *
 * @author admin
 */
public class StudentImp implements IStudent{
    public static Date addDays(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 2);
        return cal.getTime();
    }
    
    @Override
    public List<Student> getStudent(String search) {
        List<Student> result = new ArrayList();
        ResultSet rs = SqlConnection.executeQuery("{call sp_getStudent()}");
        if(search !=null){
            rs=SqlConnection.executeQuery("{call sp_searchStudent(?)}", search);
        }
        
        try {
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getString("idsv"));
                s.setName(rs.getString("hoten"));
                s.setBirthday(new java.sql.Date(addDays(rs.getDate("ngaysinh")).getTime()));
                s.setPhone(rs.getString("phone"));
                s.setEmail(rs.getString("email"));
                s.setGender(rs.getBoolean("gioitinh"));
                s.setClass_id(rs.getString("idlop"));
                s.setClass_name(rs.getString("class"));
                s.setAddress(rs.getString("diachi"));
                
                result.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Student find(String id) {
        ResultSet rs = SqlConnection.executeQuery("{call sp_findStudent(?)}",id);
        
        try {
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getString("idsv"));
                s.setName(rs.getString("hoten"));
                s.setBirthday(new java.sql.Date(addDays(rs.getDate("ngaysinh")).getTime()));
                s.setPhone(rs.getString("phone"));
                s.setEmail(rs.getString("email"));
                s.setGender(rs.getBoolean("gioitinh"));
                s.setClass_id(rs.getString("idlop"));
                s.setAddress(rs.getString("diachi"));
                
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insert(Student t) {
        SqlConnection.executeUpdate("{call sp_insertStudent(?,?,?,?,?,?,?,?)}",t.getId(),t.getName(),t.getBirthday(),t.getPhone(),t.getEmail(),t.getAddress(),t.isGender(),t.getClass_id());
    }

    @Override
    public void update(Student t) {
        SqlConnection.executeUpdate("{call sp_updateStudent(?,?,?,?,?,?,?,?)}",t.getId(),t.getName(),t.getBirthday(),t.getPhone(),t.getEmail(),t.getAddress(),t.isGender(),t.getClass_id());
    }

    @Override
    public void delete(String id) {
        SqlConnection.executeUpdate("{call sp_deleteStudent(?)}",id);
    }
    
}
