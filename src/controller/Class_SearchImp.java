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
import model.ClassSearch;

/**
 *
 * @author admin
 */
public class Class_SearchImp implements IClass_Search{

    @Override
    public List<ClassSearch> getClassSearch(String name) {
        List<ClassSearch> result = new ArrayList();
        ResultSet rs = SqlConnection.executeQuery("{call sp_getClassSearch()}");
        if(name != null){
            rs= SqlConnection.executeQuery("{call sp_SearchClassSearch(?)}",name);
        }
        try {
            while(rs.next()){
                ClassSearch cs = new ClassSearch(rs.getString("className"), rs.getString("Faculty_Name"), rs.getString("course"), rs.getInt("khoa"), rs.getInt("ma"));
                result.add(cs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Class_SearchImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
}
