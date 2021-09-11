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
import model.Mark_Type;

/**
 *
 * @author admin
 */
public class Mark_TypeImp implements IMark_Type{

    @Override
    public List<Mark_Type> getMark_Type(String name) {
        List<Mark_Type> result = new ArrayList();
        ResultSet rs = SqlConnection.executeQuery("{call sp_getMarkType()}");
        if(name !=null){
            rs = SqlConnection.executeQuery("{call sp_searchMark_Type(?)}", name);
        }
        try {
            while (rs.next()) {
                Mark_Type mt = new Mark_Type(rs.getInt("id"), rs.getString("name"));
                result.add(mt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mark_TypeImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public void insert(Mark_Type mt) {
      SqlConnection.executeUpdate("{call sp_insertMarkType(?)}",mt.getName());
        
    }

    @Override
    public void update(Mark_Type mt) {
       SqlConnection.executeUpdate("{call sp_updateMark_Type(?,?)}", mt.getId(),mt.getName());
    }

    @Override
    public void delete(int id) {
        try {
            SqlConnection.executeUpdate("{call sp_deleteMark_Type(?)}", id);
        } catch (Exception e) {
            System.err.println("Không thể xóa");
        }
        
    }

    @Override
    public Mark_Type find(int id) {
        ResultSet rs = SqlConnection.executeQuery("{call sp_findMark_Type(?)}", id);
        try {
            while (rs.next()) {
                Mark_Type mt = new Mark_Type(rs.getInt("id"), rs.getString("name"));
                return mt;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mark_TypeImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Mark_Type result(int id) {
        ResultSet rs = SqlConnection.executeQuery("{call sp_resultMark_Type(?)}", id);
        try {
            while (rs.next()) {
                Mark_Type mt = new Mark_Type(rs.getInt("id"), rs.getString("name"));
                return mt;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mark_TypeImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
