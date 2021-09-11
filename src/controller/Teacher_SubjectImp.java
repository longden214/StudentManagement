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
import model.Teacher_Subject;

/**
 *
 * @author admin
 */
public class Teacher_SubjectImp implements ITeacher_Subject{

    @Override
    public List<Teacher_Subject> getTeacher_Subject(String name) {
        List<Teacher_Subject> result = new ArrayList();
        ResultSet rs = SqlConnection.executeQuery("{call sp_getTeacher_Subject()}");
        if(name != null){
            rs = SqlConnection.executeQuery("{call sp_seacherTeacher_Subject(?)}",name);
        }
        try {
            while(rs.next()){
                Teacher_Subject ts = new Teacher_Subject();
                ts.setNameGV(rs.getString("name_gv"));
                ts.setName_Subject(rs.getString("name_Subject"));
                
                result.add(ts);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Teacher_SubjectImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public void insertTeacher_Subject(Teacher_Subject ts) {
        SqlConnection.executeUpdate("{call sp_insertTeacher_Subject(?,?)}", ts.getIdgv(),ts.getIdsb());
    }

    @Override
    public void deleteTeacher_Subject(int idgv,int idsbj) {
        SqlConnection.executeUpdate("{call sp_deleteTeacher_Subject(?,?)}", idgv,idsbj);
    }

    @Override
    public Teacher_Subject find(String idgv, String idsbj) {
       ResultSet rs = SqlConnection.executeQuery("{call sp_findTeacher_Subject(?,?)}",idgv,idsbj);
        
        try {
            while(rs.next()){
                Teacher_Subject ts = new Teacher_Subject();
                ts.setNameGV(rs.getString("nameGV"));
                ts.setName_Subject(rs.getString("nameSbj"));
                ts.setIdgv(rs.getInt("idgv"));
                ts.setIdsb(rs.getInt("idsb"));
                
                return ts;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Teacher_SubjectImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
