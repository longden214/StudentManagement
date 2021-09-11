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
import model.Faculty_Search;

/**
 *
 * @author admin
 */
public class Faculty_SearchImp implements IFaculty_Search{

    @Override
    public List<Faculty_Search> getFaculty_Search(String name) {
        List<Faculty_Search> data = new ArrayList<>();
        ResultSet rs = SqlConnection.executeQuery("{call sp_getFacultySearch()}");
        if (name != null) {
            rs = SqlConnection.executeQuery("{call sp_Search_FacultySearch(?)}",name);
        }
       
        try {
            while (rs.next()) {
                Faculty_Search f = new Faculty_Search(rs.getInt("id"), rs.getString("khoa"), rs.getInt("year"), rs.getInt("number_Teacher"));
                data.add(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Faculty_SearchImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }
    
}
