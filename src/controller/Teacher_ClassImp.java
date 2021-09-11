/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Teacher_Class;

/**
 *
 * @author admin
 */
public class Teacher_ClassImp implements ITeacher_Class{

    @Override
    public List<Teacher_Class> getTeacher_Class(String idClass) {
        List<Teacher_Class> result = new ArrayList();
        ResultSet rs = SqlConnection.executeQuery("{call sp_getTeacher_Class()}");
        if(idClass != null){
            rs = SqlConnection.executeQuery("{call sp_seacherTeacher_Class(?)}",idClass);
        }
        try {
            while(rs.next()){
                Teacher_Class tc = new Teacher_Class(rs.getString("name_gv"),rs.getString("name_Class"));
                result.add(tc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Teacher_ClassImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public void insertTeacher_Class(Teacher_Class tc) {
        SqlConnection.executeUpdate("{call sp_insertTeacher_Class(?,?)}", tc.getIdgv(),tc.getName_Class());
    }

    @Override
    public void deleteTeacher_Class(int idgv,String idClass) {
        SqlConnection.executeUpdate("{call sp_deleteTeacher_Class(?,?)}", idgv,idClass);
    }

    @Override
    public Teacher_Class find(String idgv,String idClass) {
        ResultSet rs = SqlConnection.executeQuery("{call sp_findTeacher_Class(?,?)}",idgv,idClass);

        try {
            while(rs.next()){   
                Teacher_Class tc = new Teacher_Class();
                tc.setIdgv(rs.getInt("idgv"));
                tc.setNameGV(rs.getString("nameGV"));
                tc.setName_Class(rs.getString("nameClass"));
                
                return tc;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Teacher_ClassImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
