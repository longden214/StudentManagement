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
import model.Faculty;

/**
 *
 * @author admin
 */
public class FacultyImp implements IFaculty{

    @Override
    public List<Faculty> getFaculty(String search) {
        List<Faculty> data = new ArrayList<>();
        ResultSet rs = SqlConnection.executeQuery("{call sp_getFaculty()}");
        
        if (search != null) {
            rs = SqlConnection.executeQuery("{call sp_getFindAllFaculty(?)}",search);
        }
        
        try {
            while (rs.next()) {
                Faculty f = new Faculty();
                f.setId(rs.getInt("id"));
                f.setName(rs.getString("khoa"));
                f.setYear(rs.getInt("year"));

                data.add(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacultyImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    @Override
    public Faculty find(int id) {
        ResultSet rs = SqlConnection.executeQuery("{call sp_getFindFaculty(?)}",id);
        try {
            while (rs.next()) {
                Faculty f = new Faculty();
                f.setId(rs.getInt("id"));
                f.setName(rs.getString("khoa"));
                f.setYear(rs.getInt("year"));

                return f;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacultyImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public void addCourse(Faculty f) {
        SqlConnection.executeUpdate("{call sp_addFaculty(?,?)}", f.getName(),f.getYear());
    }

    @Override
    public void editCourse(Faculty f) {
        SqlConnection.executeUpdate("{call sp_editFaculty(?,?,?)}",f.getId(),f.getName(),f.getYear());
    }

    @Override
    public void remove(int id) {
        SqlConnection.executeUpdate("{call sp_removeFaculty(?)}",id);
    }
    
}
