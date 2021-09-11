/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Class;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class ClassImp implements IClass{

    @Override
    public List<Class> getClass(String search) {
        List<Class> data = new ArrayList<>();
        ResultSet rs = SqlConnection.executeQuery("{call sp_getClass()}");
        
        if (search != null) {
            rs = SqlConnection.executeQuery("{call sp_getFindAllClass(?)}",search);
        }
        try {
            while (rs.next()) {
                Class c = new Class();
                c.setClassName(rs.getString("lop"));
                c.setFacultyId(rs.getInt("idFaculty"));
                c.setFacultyName(rs.getString("khoa"));
                c.setCourse(rs.getString("idCourse"));

                data.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }

    @Override
    public Class find(String id) {
        ResultSet rs = SqlConnection.executeQuery("{call sp_getFindClass(?)}",id);
        
        try {
            while (rs.next()) {
                Class c = new Class();
                c.setClassName(rs.getString("lop"));
                c.setFacultyId(rs.getInt("idFaculty"));
                c.setCourse(rs.getString("idCourse"));

                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public void addClass(Class c) {
        SqlConnection.executeUpdate("{call sp_addClass(?,?,?)}",c.getClassName(),c.getFacultyId(),c.getCourse());
    }

    @Override
    public void editClass(Class c) {
        SqlConnection.executeUpdate("{call sp_editClass(?,?,?)}",c.getClassName(),c.getFacultyId(),c.getCourse());
    }

    @Override
    public void removeClass(String id) {
        SqlConnection.executeUpdate("{call sp_removeClass(?)}",id);
    }
    
}
