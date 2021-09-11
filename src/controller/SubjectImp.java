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
import model.Subject;

/**
 *
 * @author admin
 */
public class SubjectImp implements ISubject{

    @Override
    public List<Subject> getSubject(String mon) {
        List<Subject> result = new ArrayList();
        ResultSet rs = SqlConnection.executeQuery("{call sp_getSubject()}");
        if(mon !=null){
            rs = SqlConnection.executeQuery("{call sp_seacherSubject(?)}", mon);
        }
        try {
            while (rs.next()) {
                Subject sb = new Subject(rs.getInt("id"), rs.getString("mon"),rs.getString("ten_Faculty"));
                result.add(sb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public void insertSubject(Subject sb) {
        SqlConnection.executeUpdate("{call sp_insertSubject(?,?)}", sb.getMon(),sb.getIdFaculty());
    }

    @Override
    public void updateSubject(Subject sb) {
        SqlConnection.executeUpdate("{call sp_updateSubject(?,?,?)}", sb.getId(),sb.getMon(),sb.getIdFaculty());
    }

    @Override
    public void deleteSubject(int id) {
        SqlConnection.executeUpdate("{call sp_deleteSubject(?)}", id);
    }

    @Override
    public Subject find(int id) {
        ResultSet rs = SqlConnection.executeQuery("{call sp_findSubject(?)}", id);
        try {
            while (rs.next()) {
                Subject sb = new Subject(rs.getInt("id"), rs.getString("mon"),rs.getInt("idFaculty"));
                return sb;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }

    
}
